package com.market.simulation.service;

import java.io.IOException;

public interface OrdersService {

    void createOrder(String symbol, String side, String quantity, String price) throws IOException;

    void cancelOrder(Long id) throws IOException;

    String getAveragePrice(String symbol) throws IOException;
}
