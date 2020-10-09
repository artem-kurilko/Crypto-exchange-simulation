package com.market.simulation.service;

import com.market.simulation.repository.OrderRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Instant;
import java.util.UUID;

import static java.lang.String.valueOf;

/**
 * Implementation of {@link OrderService} interface
 *
 * @author Kurilko Artemii
 * @version 1.0
 */

@Service
public class OrderServiceImpl implements OrderService {
    private final int accuracy = 5;
    private final OrderRepository orderRepository;
    private final Logger log = LoggerFactory.getLogger("OrdersServiceImpl");

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void createOrder(Long userId, String API, String symbol, String side, String quantity, String price) throws IOException {
        String createdAt = valueOf(Instant.now());
        String cumQuantity = "0.0";
        String status = "new";
        String clientOrderId = UUID.randomUUID().toString();


        log.info("placed new " + side + " order");
    }

    @Override
    public void cancelOrder(String key, String clientOrderId) throws IOException {

    }

    @Override
    public String getAveragePrice(String symbol) throws IOException {
        return null;
    }

    @Override
    public JSONArray getActiveOrders(String key) {
        return null;
    }

    @Override
    public JSONObject getLastActiveOrder(String key) {
        return null;
    }

    @Override
    public JSONArray getTradeHistory(String key) {
        return null;
    }

    @Override
    public JSONObject getLastTradeHistory(String key) {
        return null;
    }

}
