package com.market.simulation.service;

public interface OrdersService {

    void placeOrder(String side, String quantity, String price, String currencyPair);

    void cancelOrder(Long id);

    String getAveragePrice(String currencyPair);
}
