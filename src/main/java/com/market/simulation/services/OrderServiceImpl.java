package com.market.simulation.services;

import com.market.simulation.domain.ActiveOrders;
import com.market.simulation.domain.Order;
import com.market.simulation.domain.OrderStatus;
import com.market.simulation.exception.UserNotFoundException;
import com.market.simulation.repository.ActiveOrdersRepository;
import com.market.simulation.repository.OrderRepository;
import com.market.simulation.repository.OrdersHistoryRepository;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * Implementation of {@link com.market.simulation.services.OrderService} interface.
 *
 * @author Artemii Kurilko
 * @version 1.0
 */

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ActiveOrdersRepository activeOrdersRepository;
    private final OrdersHistoryRepository ordersHistoryRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ActiveOrdersRepository activeOrdersRepository, OrdersHistoryRepository ordersHistoryRepository) {
        this.orderRepository = orderRepository;
        this.activeOrdersRepository = activeOrdersRepository;
        this.ordersHistoryRepository = ordersHistoryRepository;
    }

    @Override
    public void placeOrder(Long userId, boolean isBuy, String side, float price, float quantity) {
        String symbol = "BTCUSDT";
        float cumQuantity = (float) 0.0;
        Long createdAt = new Timestamp(System.currentTimeMillis()).getTime();
        Order order = new Order(userId, symbol, side, OrderStatus.NEW, quantity, price, cumQuantity, createdAt);
        orderRepository.save(order);
    }

    @Override
    public void cancelOrder(Long userId, Long orderId) throws UserNotFoundException {
        ActiveOrders activeOrder = activeOrdersRepository.findById(orderId).orElseThrow(() -> new UserNotFoundException("User with id: " + userId + " not found."));
        activeOrdersRepository.delete(activeOrder);
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
