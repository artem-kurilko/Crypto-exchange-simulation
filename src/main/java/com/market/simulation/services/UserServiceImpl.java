package com.market.simulation.services;

import com.market.simulation.domain.User;
import com.market.simulation.exception.SymbolNotFoundException;
import com.market.simulation.exception.UserNotFoundException;
import com.market.simulation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link UserService} interface.
 *
 * @author Artemii Kurilko
 * @version 1.0
 * @see com.market.simulation.resource.UserController
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(Long userId, String name, float btcBalance, float usdtBalance) {
        User user = new User(userId, name, btcBalance, 0.0F, usdtBalance, 0.0F);
        userRepository.save(user);
    }

    @Override
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

    @Override
    public void transferCurrency(Long userId, String symbol, boolean isOrderCanceled, float quantity) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User with id: " + userId + " not found"));
        float freeBalance;
        float reservedBalance;

        if (symbol.equals("BTC")) {
            if (isOrderCanceled){
                freeBalance = getFreeBTCBalance(userId) + quantity;
                reservedBalance = getReservedBTCBalance(userId) - quantity;
            } else {
                freeBalance = getFreeBTCBalance(userId) - quantity;
                reservedBalance = getReservedBTCBalance(userId) + quantity;
            }
            user.setBtcBalanceFree(freeBalance);
            user.setBtcBalanceReserved(reservedBalance);
        } else if (symbol.equals("USDT")){
            if (isOrderCanceled){
                freeBalance = getFreeUSDTBalance(userId) + quantity;
                reservedBalance = getReservedUSDTBalance(userId) - quantity;
            } else {
                freeBalance = getFreeUSDTBalance(userId) - quantity;
                reservedBalance = getReservedUSDTBalance(userId) + quantity;
            }
            user.setUsdtBalanceFree(freeBalance);
            user.setUsdtBalanceReserved(reservedBalance);
        } else
            throw new SymbolNotFoundException("Symbol: " + symbol + " not found.");
    }

}