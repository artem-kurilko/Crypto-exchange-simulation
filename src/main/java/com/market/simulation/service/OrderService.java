package com.market.simulation.service;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Service interface for {@link com.market.simulation.domain.Order} class.
 *
 * @author Kurilko Artemii
 * @version 1.0
 */

public interface OrderService {

    void createOrder(Long userId, String key, String symbol, String side, String quantity, String price) throws IOException;

    void cancelOrder(String key, String clientOrderId) throws IOException;

    String getAveragePrice(String symbol) throws IOException;

    JSONArray getActiveOrders(String key);

    JSONObject getLastActiveOrder(String key);

    JSONArray getTradeHistory(String key);

    JSONObject getLastTradeHistory(String key);

}
