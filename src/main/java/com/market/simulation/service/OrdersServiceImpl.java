package com.market.simulation.service;

import com.market.simulation.domain.Order;
import com.market.simulation.repository.OrdersRepository;
import com.market.simulation.repository.UserRepository;
import org.apache.commons.math3.util.Precision;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.String.valueOf;

/**
 *  Implementation of {@link OrdersService} interface
 *
 * @author Kurilko Artemii
 * @version 1.0
 */

@Service
public class OrdersServiceImpl implements OrdersService{
    private final int accuracy = 5;
    private final OrdersRepository ordersRepository;
    private final Logger log = LoggerFactory.getLogger("OrdersServiceImpl");

    @Autowired
    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public void createOrder(String symbol, String side, String quantity, String price) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createdAt = simpleDateFormat.format(date);
        String cumQuantity = "0.0";
        String status = "new";
        Order order = new Order(symbol, side, quantity, price, createdAt, cumQuantity, status);

        Order newOrder = ordersRepository.save(order);
        log.info("place order " + newOrder);
    }

    @Override
    public void cancelOrder(Long id) {
        ordersRepository.deleteById(id);
        log.info("canceled order, order id: " + id);
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
