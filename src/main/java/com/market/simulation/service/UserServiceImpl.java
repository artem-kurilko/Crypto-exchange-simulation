package com.market.simulation.service;

import com.market.simulation.domain.User;
import com.market.simulation.exception.UserNotFoundException;
import com.market.simulation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link UserService} interface
 *
 * @author Artemii Kurilko
 * @version 1.0
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserByKey(String key) throws UserNotFoundException{
        User user = userRepository.findUserByKey(key);
        if (user == null)
            throw new UserNotFoundException("User not found");
        else return user;
    }

    @Override
    public float getFreeBTCBalance(String key) throws UserNotFoundException {
        return findUserByKey(key).getBtcBalanceFree();
    }

    @Override
    public float getReservedBTCBalance(String key) throws UserNotFoundException {
        return findUserByKey(key).getBtcBalanceReserved();
    }

    @Override
    public float getFreeUSDTBalance(String key) throws UserNotFoundException {
        return findUserByKey(key).getUsdtBalanceFree();
    }

    @Override
    public float getReservedUSDTBalance(String key) throws UserNotFoundException {
        return findUserByKey(key).getUsdtBalanceReserved();
    }

}
