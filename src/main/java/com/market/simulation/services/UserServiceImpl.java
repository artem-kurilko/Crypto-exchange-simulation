package com.market.simulation.services;

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

    public User findUserById(Long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User with id: " + userId + " not found"));
        if (user == null)
            throw new UserNotFoundException("User not found");
        else return user;
    }

    @Override
    public float getFreeBTCBalance(Long userId) throws UserNotFoundException {
        return findUserById(userId).getBtcBalanceFree();
    }

    @Override
    public float getReservedBTCBalance(Long userId) throws UserNotFoundException {
        return findUserById(userId).getBtcBalanceReserved();
    }

    @Override
    public float getFreeUSDTBalance(Long userId) throws UserNotFoundException {
        return findUserById(userId).getUsdtBalanceFree();
    }

    @Override
    public float getReservedUSDTBalance(Long userId) throws UserNotFoundException {
        return findUserById(userId).getUsdtBalanceReserved();
    }

}
