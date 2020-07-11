package com.market.simulation.service;

import org.json.JSONArray;
import org.json.JSONObject;

public interface UserService {

    JSONArray getActiveOrders();

    JSONObject getLastActiveOrder();

    JSONArray getOrdersHistory();

    JSONObject getLastOrderHistory();

    String getBalance(String currency);

    String getUSDTBalance();

    String getBTCBalance();

    String getETHBalance();
}
