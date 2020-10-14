package com.market.simulation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception class for {@link com.market.simulation.domain.User} class.
 *
 * @author Kurilko Artemii
 * @version 1.0
 */

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class SymbolNotFoundException extends Exception{

    public SymbolNotFoundException(String message){
        super(message);
    }

}
