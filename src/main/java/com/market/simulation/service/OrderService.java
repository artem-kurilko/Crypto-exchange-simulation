package com.market.simulation.service;

import java.io.IOException;

/**
 * Service interface for {@link com.market.simulation.domain.Order} class.
 *
 * @author Kurilko Artemii
 * @version 1.0
 */

public interface OrderService {

    void createOrder(String API, Long clientOrderId, String symbol, String side, String quantity, String price) throws IOException;

    void cancelOrder(String API, Long clientOrderId) throws IOException;

    String getAveragePrice(String symbol) throws IOException;
}
