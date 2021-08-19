package com.market.simulation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception class for {@link com.market.simulation.domain.User} class.
 *
 * @author Kurilko Artemii
 * @version 1.0
 * @see com.market.simulation.services.UserServiceImpl
 * @see com.market.simulation.services.OrderServiceImpl
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UserNotFoundException extends Exception {

    public UserNotFoundException(String message) {
        super(message);
    }

}
