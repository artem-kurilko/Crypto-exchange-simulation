package com.market.simulation.services;

import com.market.simulation.exception.UserNotFoundException;
import org.json.JSONArray;

/**
 * Service interface for {@link com.market.simulation.domain.Order} class.
 *
 * @author Kurilko Artemii
 * @version 1.0
 */

public interface OrderService {

    /**
     * Is used to place buy/sell order.
     * @param isBuy boolean
     */
    void placeOrder(Long userId, boolean isBuy, String side, float price, float quantity);

    /**
     * Is used to cancel user's active order by given id.
     * @param userId user id
     * @throws UserNotFoundException if {@code userId} not found
     */
    void cancelOrder(Long userId, Long orderId) throws UserNotFoundException;

    /**
     * Returns user's active orders.
     * @return json array
     */
    JSONArray getActiveOrders(Long userId);

    /**
     * Returns user's orders history.
     * @return json array
     */
    JSONArray getOrdersHistory(Long userId);

}
