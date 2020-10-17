package com.market.simulation.exception;

/**
 * Exception class for {@link com.market.simulation.domain.User} class.
 *
 * @author Kurilko Artemii
 * @version 1.0
 * @see com.market.simulation.services.UserServiceImpl
 */

public class SymbolNotFoundException extends RuntimeException {

    public SymbolNotFoundException(String message) {
        super(message);
    }

}
