package com.market.simulation.service;

import com.market.simulation.domain.User;
import com.market.simulation.exception.UserNotFoundException;

/**
 * Service interface for {@link com.market.simulation.domain.User} class.
 *
 * @author Kurilko Artemii
 * @version 1.0
 */

public interface UserService {

    /**
     * Returns user by given key.
     * @param key user's key
     * @return User instance.
     */
    User findUserByKey(String key) throws UserNotFoundException;

    /**
     * Returns user's free btc balance.
     * @param key user's key
     * @return float value.
     */
    float getFreeBTCBalance(String key) throws UserNotFoundException;

    /**
     * Returns user's reserved btc balance.
     * @param key user's key
     * @return float value.
     */
    float getReservedBTCBalance(String key) throws UserNotFoundException;

    /**
     * Returns user's free usdt balance.
     * @return float value.
     */
    float getFreeUSDTBalance(String key) throws UserNotFoundException;

    /**
     * Returns user's reserved usdt balance.
     * @return float value.
     */
    float getReservedUSDTBalance(String key) throws UserNotFoundException;

}
