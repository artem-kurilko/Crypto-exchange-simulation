package com.market.simulation.service;

import com.market.simulation.domain.User;
import com.market.simulation.exception.UserNotFoundException;
import com.market.simulation.repository.UserRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Implementation of {@link UserService} interface
 *
 * @author Artemii Kurilko
 * @version 1.0
 */

public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByApi(String API) throws UserNotFoundException{
        User user = userRepository.findUserByAPI(API);
        if (user == null)
            throw new UserNotFoundException("user not found");
        else return user;
    }

    @Override
    public JSONArray getActiveOrders(String API) {
        User user = userRepository.findUserByAPI(API);
        user.getId();
        return null;
    }

    @Override
    public JSONObject getLastActiveOrder(String API) {
        return null;
    }

    @Override
    public JSONArray getTradeHistory(String API) {
        return null;
    }

    @Override
    public JSONObject getLastTradeHistory(String API) {
        return null;
    }

    @Override
    public String getBalance(String API, String currency) {
        return null;
    }

    @Override
    public String getUSDTBalance(String API) {
        return null;
    }

    @Override
    public String getBTCBalance(String API) {
        return null;
    }

    @Override
    public String getETHBalance(String API) {
        return null;
    }
}
