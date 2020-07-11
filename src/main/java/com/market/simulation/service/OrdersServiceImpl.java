package com.market.simulation.service;

import org.springframework.stereotype.Service;

/**
 *  Implementation of OrdersService.class
 */

@Service
public class OrdersServiceImpl implements OrdersService{

    @Override
    public void placeOrder(boolean isBuy, String quantity, String price, String currencyPair) {

    }

    @Override
    public void cancelOrder(String clientOrderId) {

    }

    @Override
    public void getOpenOrders() {

    }

    @Override
    public String getAveragePrice(String currencyPair) {
        return null;
    }
}
