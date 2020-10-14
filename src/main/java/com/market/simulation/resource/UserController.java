package com.market.simulation.resource;

import com.market.simulation.domain.User;
import com.market.simulation.exception.UserNotFoundException;
import com.market.simulation.services.UserServiceImpl;
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
 * @author Kurilko Artemii
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
    public ResponseEntity<User> getUserData(@RequestParam @NotNull Long userId) throws UserNotFoundException {
        User user = userServiceImpl.findUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/balance/btc/free")
    public ResponseEntity<String> getFreeBTCBalance(@RequestParam @NotNull Long userId) throws UserNotFoundException {
        float btcBalance = userServiceImpl.getFreeBTCBalance(userId);
        return new ResponseEntity<>(String.valueOf(btcBalance), HttpStatus.OK);
    }

    @GetMapping("/balance/btc/reserved")
    public ResponseEntity<String> getReservedBTCBalance(@RequestParam @NotNull Long userId) throws UserNotFoundException {
        float btcBalance = userServiceImpl.getReservedBTCBalance(userId);
        return new ResponseEntity<>(String.valueOf(btcBalance), HttpStatus.OK);
    }

    @GetMapping("/balance/usdt/free")
    public ResponseEntity<String> getFreeUSDTBalance(@RequestParam @NotNull Long userId) throws UserNotFoundException {
        float usdtBalance = userServiceImpl.getFreeUSDTBalance(userId);
        return new ResponseEntity<>(String.valueOf(usdtBalance), HttpStatus.OK);
    }

    @GetMapping("/balance/usdt/reserved")
    public ResponseEntity<String> getReservedUSDTBalance(@RequestParam @NotNull Long userId) throws UserNotFoundException {
        float usdtBalance = userServiceImpl.getReservedUSDTBalance(userId);
        return new ResponseEntity<>(String.valueOf(usdtBalance), HttpStatus.OK);
    }

}