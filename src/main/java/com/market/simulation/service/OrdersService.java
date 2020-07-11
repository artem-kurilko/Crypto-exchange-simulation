package com.market.simulation.service;

public interface OrdersService {

    void placeOrder(boolean isBuy, String quantity, String price, String currencyPair);

    void cancelOrder(String clientOrderId);

    void getOpenOrders();

    String getAveragePrice(String currencyPair);
}
