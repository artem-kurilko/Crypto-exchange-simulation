package com.market.simulation.services.orderstream;

import com.market.simulation.exception.UserNotFoundException;

/**
 * BinanceApiCallback is a functional interface used together with the BinanceApiAsyncClient to provide a non-blocking REST client.
 *
 * @param <T> the return type from the callback
 *
 * @author Artemii Kurilko
 * @version 1.0
 */

@FunctionalInterface
public interface BinanceApiCallback<T> {

    /**
     * Called whenever a response comes back from the Binance API.
     *
     * @param response the expected response object
     */
    void onResponse(T response) throws UserNotFoundException, SymbolNotFoundException;

    /**
     * Called whenever an error occurs.
     *
     * @param cause the cause of the failure
     */
    default void onFailure(Throwable cause) {}

}