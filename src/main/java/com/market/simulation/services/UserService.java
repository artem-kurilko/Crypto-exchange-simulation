package com.market.simulation.services;

import com.market.simulation.exception.UserNotFoundException;

/**
 * Service interface for {@link com.market.simulation.domain.User} class.
 *
 * @author Kurilko Artemii
 * @version 1.0
 */

public interface UserService {

    /**
     * Returns user's free btc balance.
     * @param userId user's id
     * @return float value.
     */
    float getFreeBTCBalance(Long userId) throws UserNotFoundException;

    /**
     * Returns user's reserved btc balance.
     * @param userId user's id
     * @return float value.
     */
    float getReservedBTCBalance(Long userId) throws UserNotFoundException;

    /**
     * Returns user's free usdt balance.
     * @return float value.
     */
    float getFreeUSDTBalance(Long userId) throws UserNotFoundException;

    /**
     * Returns user's reserved usdt balance.
     * @return float value.
     */
    float getReservedUSDTBalance(Long userId) throws UserNotFoundException;

}
