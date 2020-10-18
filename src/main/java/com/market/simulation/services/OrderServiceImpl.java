package com.market.simulation.services;

import com.market.simulation.domain.ActiveOrder;
import com.market.simulation.domain.Order;
import com.market.simulation.domain.OrderStatus;
import com.market.simulation.domain.OrderHistory;
import com.market.simulation.exception.OrderNotFoundException;
import com.market.simulation.exception.UserNotFoundException;
import com.market.simulation.repository.ActiveOrdersRepository;
import com.market.simulation.repository.OrderRepository;
import com.market.simulation.repository.OrdersHistoryRepository;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

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

    // FIXME: we use activeOrders orderId, but we need also Order orderId
    @Override
    public void cancelOrder(Long userId, Long orderId, Long createdAt, boolean isExecuted) throws OrderNotFoundException, UserNotFoundException {
        ActiveOrder activeOrder = activeOrdersRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order with id: " + orderId + " not found."));
        Order order = orderRepository.findOne(Query.query(Criteria.where("userId").is(userId).and("createdAt").is(createdAt)), Order.class);
        order.setStatus(OrderStatus.CANCELED);
        String symbol = activeOrder.getSide().equals("buy") ? "USDT" : "BTC";
        float quantity = activeOrder.getQuantity();
        activeOrdersRepository.delete(activeOrder);

        if (!isExecuted)
            userService.transferCurrency(userId, symbol, true, quantity);
    }

    @Override
    public void executeActiveOrder(Long userId, Long orderId) throws UserNotFoundException, OrderNotFoundException {
        OrderHistory order = (OrderHistory) orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order with id: " + orderId + " not found."));
        order.setStatus(OrderStatus.FILLED);
        ordersHistoryRepository.save(order);
        cancelOrder(userId, orderId, true);
    }

    // TODO: add partially filled status
    @Override
    public void executeActiveOrderPartially(Long userId, Long orderId, float quantity) throws OrderNotFoundException {
        ActiveOrder activeOrder = (ActiveOrder) orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order with id: " + orderId + " not found."));
        activeOrder.setCumQuantity(quantity);
        activeOrder.setQuantity(activeOrder.getQuantity()-quantity);
    }

    @Override
    public JSONArray getActiveOrders(Long userId) {
        JSONArray activeOrders = new JSONArray(activeOrdersRepository.findAll().stream().filter(order -> order.getClientOrderId().equals(userId)));
        return activeOrders;
    }

    @Override
    public JSONArray getOrdersHistory(Long userId) {
        JSONArray ordersHistory = new JSONArray(ordersHistoryRepository.findAll().stream().filter(order -> order.getClientOrderId().equals(userId)));
        return ordersHistory;
    }

}
