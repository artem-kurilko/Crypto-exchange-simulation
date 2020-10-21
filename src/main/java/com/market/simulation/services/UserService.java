package com.market.simulation.services;

import com.market.simulation.domain.User;
import com.market.simulation.exception.SymbolNotFoundException;
import com.market.simulation.exception.UserNotFoundException;

/**
 * Service interface for {@link com.market.simulation.domain.User} class.
 *
 * @author Kurilko Artemii
 * @version 1.0
 * @see com.market.simulation.services.UserServiceImpl
 */

public interface UserService {

    /**
     * Creates user with specified data.
     * @param userId user's id
     * @param name user's name
     * @param btcBalance user's btc balance
     * @param usdtBalance user's usdt balance
     */
    void createUser(Long userId, String name, float btcBalance, float usdtBalance);

    /**
     * Returns all user information.
     * @param userId user id
     * @return User instance
     * @throws UserNotFoundException if {@code userId} not found
     */
    User findUserById(Long userId) throws UserNotFoundException;

    /**
     * Returns user's free btc balance.
     * @param userId user's id
     * @return float value
     * @throws UserNotFoundException if {@code userId} not found
     */
    float getFreeBTCBalance(Long userId) throws UserNotFoundException;

    /**
     * Returns user's reserved btc balance.
     * @param userId user's id
     * @return float value
     * @throws UserNotFoundException if {@code userId} not found
     */
    float getReservedBTCBalance(Long userId) throws UserNotFoundException;

    /**
     * Returns user's free usdt balance.
     * @return float value
     * @throws UserNotFoundException if {@code userId} not found
     */
    float getFreeUSDTBalance(Long userId) throws UserNotFoundException;

    /**
     * Returns user's reserved usdt balance.
     * @return float value
     * @throws UserNotFoundException if {@code userId} not found
     */
    float getReservedUSDTBalance(Long userId) throws UserNotFoundException;

    /**
     * Used to transfer currency from free to reserved or vice versa if order is canceled,
     * changes currency balance if user place/cancel order.
     *
     * @param userId user id
     * @param symbol currency symbol
     * @param transferToFree transfer currency to free or reserved
     * @param quantity balance quantity to transfer
     * @throws SymbolNotFoundException if {@code symbol} not found
     * @throws UserNotFoundException if {@code userId} not found
     */
    void transferCurrency(Long userId, String symbol, boolean transferToFree, float quantity) throws SymbolNotFoundException, UserNotFoundException;

}
