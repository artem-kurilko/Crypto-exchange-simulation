package com.market.simulation.service;

import org.json.JSONArray;

public interface OrdersService {

    void placeOrder(String side, String quantity, String price, String currencyPair);

    void cancelOrder(Long id);

    JSONArray getOpenOrders();

    String getAveragePrice(String currencyPair);
}
