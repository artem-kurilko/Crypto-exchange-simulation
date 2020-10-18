package com.market.simulation.services;

import com.market.simulation.exception.OrderNotFoundException;
import com.market.simulation.exception.UserNotFoundException;
import org.json.JSONArray;

/**
 * Service interface for {@link com.market.simulation.domain.Order} class,
 *
 * @author Kurilko Artemii
 * @version 1.0
 * @see com.market.simulation.services.OrderServiceImpl
 */

public interface OrderService {

    /**
     * Is used to place buy/sell order.
     * @param isBuy boolean
     * @throws UserNotFoundException if user not found by given {@code userId}
     */
    void placeOrder(Long userId, boolean isBuy, String side, float price, float quantity) throws UserNotFoundException;

    /**
     * Is used to cancel user's active order by given id.
     * @param userId user id
     * @param orderId order id
     * @param isExecuted if order is executed
     * @throws OrderNotFoundException if order with {@code orderId} not found
     * @throws UserNotFoundException if user not found by given {@code userId}
     */
    void cancelOrder(Long userId, Long orderId, Long createdAt, boolean isExecuted) throws OrderNotFoundException, UserNotFoundException;

    /**
     * Executes active order and adds it to orders history.
     *
     * @param userId user id
     * @param orderId order id
     * @throws UserNotFoundException if user not found by given {@code userId}
     * @throws OrderNotFoundException if order with {@code orderId} not found
     */
    void executeActiveOrder(Long userId, Long orderId) throws UserNotFoundException, OrderNotFoundException;

    /**
     * Executes active order partially.
     *
     * @param userId user id
     * @param orderId order id
     * @throws OrderNotFoundException if order with {@code orderId} not found
     */
    void executeActiveOrderPartially(Long userId, Long orderId, float quantity) throws OrderNotFoundException;

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
