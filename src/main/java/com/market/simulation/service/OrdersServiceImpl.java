package com.market.simulation.service;

import com.market.simulation.repository.OrdersRepository;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  Implementation of OrdersService.class
 */

@Service
public class OrdersServiceImpl implements OrdersService{

    private OrdersRepository ordersRepository;

    @Autowired
    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public void placeOrder(String side, String quantity, String price, String currencyPair) {

    }

    @Override
    public void cancelOrder(Long id) {
        ordersRepository.deleteById(id);
    }

    @Override
    public JSONArray getOpenOrders() {
        return null;
    }

    @Override
    public String getAveragePrice(String currencyPair) {
        return null;
    }
}
