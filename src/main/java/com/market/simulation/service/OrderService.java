package com.market.simulation.service;

import java.io.IOException;

/**
 * Service interface for {@link com.market.simulation.domain.Order} class.
 *
 * @author Kurilko Artemii
 * @version 1.0
 */

public interface OrderService {

    void createOrder(Long userId, String API, String symbol, String side, String quantity, String price) throws IOException;

    void cancelOrder(String API, String clientOrderId) throws IOException;

    String getAveragePrice(String symbol) throws IOException;

}
