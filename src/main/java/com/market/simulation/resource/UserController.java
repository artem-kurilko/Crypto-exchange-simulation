package com.market.simulation.resource;

import com.market.simulation.domain.User;
import com.market.simulation.exception.UserNotFoundException;
import com.market.simulation.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * REST controller for {@link com.market.simulation.domain.User} class.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

@RestController
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUserData(@RequestParam @NotNull String key) throws UserNotFoundException {
        User user = userServiceImpl.findUserByKey(key);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/balance/btc")
    public ResponseEntity<String> getBTCBalance(@RequestParam @NotNull String key) throws UserNotFoundException {
        float btcBalance = userServiceImpl.getBTCBalance(key);
        return new ResponseEntity<>(String.valueOf(btcBalance), HttpStatus.OK);
    }

    @GetMapping("/balance/usdt")
    public ResponseEntity<String> getUSDTBalance(@RequestParam @NotNull String key) throws UserNotFoundException {
        float usdtBalance = userServiceImpl.getUSDTBalance(key);
        return new ResponseEntity<>(String.valueOf(usdtBalance), HttpStatus.OK);
    }

}