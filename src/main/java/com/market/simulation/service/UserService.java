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
     * Returns user's btc balance.
     * @param key user's key
     * @return float value.
     */
    float getBTCBalance(String key) throws UserNotFoundException;

    /**
     * Returns user's usdt balance.
     * @return float value.
     */
    float getUSDTBalance(String key) throws UserNotFoundException;

}
