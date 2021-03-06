package com.market.simulation.services;

import com.market.simulation.domain.*;
import com.market.simulation.exception.OrderNotFoundException;
import com.market.simulation.exception.UserNotFoundException;
import com.market.simulation.repository.ActiveOrdersRepository;
import com.market.simulation.repository.OrderRepository;
import com.market.simulation.repository.OrdersHistoryRepository;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.stream.Stream;

/**
 * Implementation of {@link com.market.simulation.services.OrderService} interface.
 *
 * @author Artemii Kurilko
 * @version 1.0
 * @see com.market.simulation.resource.OrderController
 */
@Service
public class OrderServiceImpl implements OrderService {
    private final UserServiceImpl userService;
    private final OrderRepository orderRepository;
    private final ActiveOrdersRepository activeOrdersRepository;
    private final OrdersHistoryRepository ordersHistoryRepository;

    @Autowired
    public OrderServiceImpl(UserServiceImpl userService,
                            OrderRepository orderRepository,
                            ActiveOrdersRepository activeOrdersRepository,
                            OrdersHistoryRepository ordersHistoryRepository) {
        this.userService = userService;
        this.orderRepository = orderRepository;
        this.activeOrdersRepository = activeOrdersRepository;
        this.ordersHistoryRepository = ordersHistoryRepository;
    }

    @Override
    public void placeOrder(Long userId, boolean isBuy, String side, float price, float quantity) throws UserNotFoundException {
        String currencyPair = "BTCUSDT";
        String symbol = isBuy ? "USDT" : "BTC";
        float cumQuantity = (float) 0.0;
        Long createdAt = new Timestamp(System.currentTimeMillis()).getTime();

        Order order = new Order(userId, currencyPair, side, OrderStatus.NEW, quantity, price, cumQuantity, createdAt);
        orderRepository.save(order);
        userService.transferCurrency(userId, symbol, true, quantity);
    }

    @Override
    public void cancelOrder(Long userId, Long orderId, boolean isExecuted) throws OrderNotFoundException, UserNotFoundException {
        ActiveOrder activeOrder = activeOrdersRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order with id: " + orderId + " not found."));
        Long createdAt = activeOrder.getCreatedAt();
        activeOrdersRepository.delete(activeOrder);
        Order order = orderRepository.findOrderByUserIdAndCreatedAt(orderId, createdAt);
        order.setStatus(OrderStatus.CANCELED);
        String symbol = activeOrder.getSide().equals("buy") ? "USDT" : "BTC";
        float quantity = activeOrder.getQuantity();

        if (!isExecuted)
            userService.transferCurrency(userId, symbol, true, quantity);
    }

    @Override
    public void executeActiveOrder(Long userId, Long orderId) throws UserNotFoundException, OrderNotFoundException {
        ActiveOrder activeOrder = activeOrdersRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order with id: " + orderId + " not found."));
        Order order = orderRepository.findOrderByUserIdAndCreatedAt(userId, activeOrder.getCreatedAt());
        OrderHistory ordersHistory = (OrderHistory) order;
        order.setStatus(OrderStatus.FILLED);
        ordersHistoryRepository.save(ordersHistory);
        cancelOrder(userId, orderId, true);
    }

    @Override
    public void executeActiveOrderPartially(Long userId, Long orderId, float quantity) throws OrderNotFoundException, UserNotFoundException {
        ActiveOrder activeOrder = (ActiveOrder) orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order with id: " + orderId + " not found."));
        activeOrder.setCumQuantity(quantity);
        activeOrder.setStatus(OrderStatus.PARTIALLY_FILLED);
        Order order = orderRepository.findOrderByUserIdAndCreatedAt(userId, activeOrder.getCreatedAt());
        order.setStatus(OrderStatus.PARTIALLY_FILLED);
        String side = activeOrder.getSide();

        User user = userService.findUserById(userId);

        if (side.equals("buy")) {
            float btcBalance = userService.getFreeBTCBalance(userId) + quantity / activeOrder.getPrice();
            user.setBtcBalanceFree(btcBalance);
        }
        else {
            float usdtBalance = userService.getFreeUSDTBalance(userId) + quantity * activeOrder.getPrice();
            user.setUsdtBalanceFree(usdtBalance);
        }
    }

    @Override
    public JSONArray getActiveOrders(Long userId) {
        Stream<ActiveOrder> activeOrders = activeOrdersRepository.findAll().stream().filter(order -> order.getClientOrderId().equals(userId));
        return new JSONArray(activeOrders);
    }

    @Override
    public JSONArray getOrdersHistory(Long userId) {
        Stream<OrderHistory> ordersHistory = ordersHistoryRepository.findAll().stream().filter(order -> order.getClientOrderId().equals(userId));
        return new JSONArray(ordersHistory);
    }

}
