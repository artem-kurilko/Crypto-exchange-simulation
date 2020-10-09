package com.market.simulation.service;

import com.market.simulation.domain.Balance;
import com.market.simulation.domain.Order;
import com.market.simulation.repository.BalanceRepository;
import com.market.simulation.repository.OrderRepository;
import org.apache.commons.math3.util.Precision;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    private final ActiveOrdersRepository activeOrdersRepository;
    private final BalanceRepository balanceRepository;
    private final Logger log = LoggerFactory.getLogger("OrdersServiceImpl");

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ActiveOrdersRepository activeOrdersRepository, BalanceRepository balanceRepository) {
        this.orderRepository = orderRepository;
        this.activeOrdersRepository = activeOrdersRepository;
        this.balanceRepository = balanceRepository;
    }

    @Override
    public void createOrder(Long userId, String API, String symbol, String side, String quantity, String price) throws IOException {
        String createdAt = valueOf(Instant.now());
        String cumQuantity = "0.0";
        String status = "new";
        String clientOrderId = UUID.randomUUID().toString();

        Order newOrder = new Order(userId, clientOrderId, symbol, side, quantity, price, createdAt, cumQuantity, status);
        ActiveOrders activeOrder = (ActiveOrders) newOrder;

        orderRepository.insert(newOrder);
        activeOrdersRepository.insert(activeOrder);
        Balance balance = balanceRepository.findByUserId(userId);

        log.info("placed new " + side + " order");
    }

    @Override
    public void cancelOrder(String API, String clientOrderId) throws IOException {
        ActiveOrders activeOrder = activeOrdersRepository.findByClientOrderId(clientOrderId);
        Order order = orderRepository.findByClientOrderId(clientOrderId);
        order.setStatus("canceled");

        activeOrdersRepository.delete(activeOrder);
        log.info("order has been canceled: " + clientOrderId);
    }

    @Override
    public String getAveragePrice(String symbol) throws IOException {
        String command = "curl -X GET \"https://api.hitbtc.com/api/2/public/trades/" + symbol + "?sort=DESC&by=timestamp&limit=100\" -H \"accept: application/json\"";
        Process process = Runtime.getRuntime().exec(command);

        BufferedReader output = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String stream = output.readLine();

        JSONArray ordersList = new JSONArray(stream);
        double price = 0.0;
        int i = 0;
        for (i = 0; i < ordersList.length(); i++) {
            price += Double.parseDouble(ordersList.getJSONObject(i).getString("price"));
        }

        double avgPrice = price / i;
        return valueOf(Precision.round(avgPrice, accuracy));
    }
}
