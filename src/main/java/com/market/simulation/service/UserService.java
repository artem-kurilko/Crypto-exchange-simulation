package com.market.simulation.service;

import com.market.simulation.domain.User;
import com.market.simulation.exception.UserNotFoundException;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Service interface for {@link com.market.simulation.domain.User} class.
 *
 * @author Kurilko Artemii
 * @version 1.0
 */

public interface UserService {
    User getUserByApi(String API) throws UserNotFoundException;

    JSONArray getActiveOrders(String API);

    JSONObject getLastActiveOrder(String API);

    JSONArray getTradeHistory(String API);

    JSONObject getLastTradeHistory(String API);

    String getBalance(String API, String currency);

    String getUSDTBalance(String API);

    String getBTCBalance(String API);

    String getETHBalance(String API);
}
