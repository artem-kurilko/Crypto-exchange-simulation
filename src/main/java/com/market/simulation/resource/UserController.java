package com.market.simulation.resource;

import com.market.simulation.service.OrdersServiceImpl;
import com.market.simulation.service.UserServiceImpl;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.io.IOException;

/**
 * REST controller for {@link com.market.simulation.domain.User} connected requests.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

@RestController
@RequestMapping("http://localhost:8080")
public class UserController {

    private final OrdersServiceImpl ordersService;
    private final UserServiceImpl userService;

    @Autowired
    public UserController(OrdersServiceImpl ordersService, UserServiceImpl userService) {
        this.ordersService = ordersService;
        this.userService = userService;
    }

    @GetMapping("/active-orders")
    private ResponseEntity<JSONArray> getActiveOrders(@RequestHeader("authorization") String API) throws IOException{
        JSONArray activeOrders = userService.getActiveOrders();
        return new ResponseEntity<>(activeOrders, HttpStatus.OK);
    }

    @GetMapping("/active-orders/last")
    private ResponseEntity<JSONObject> getLastActiveOrder(@RequestHeader("authorization") String API) throws IOException{
        JSONObject lastActiveOrder = userService.getLastActiveOrder();
        return new ResponseEntity<>(lastActiveOrder, HttpStatus.OK);
    }

    @GetMapping("/order-history")
    private ResponseEntity<JSONArray> getTradeHistory(@RequestHeader("authorization") String API) throws IOException{
        JSONArray tradeHistory = userService.getTradeHistory();
        return new ResponseEntity<>(tradeHistory, HttpStatus.OK);
    }

    @GetMapping("/order-history/last")
    private ResponseEntity<JSONObject> getLastTradeHistory(@RequestHeader("authorization") String API) throws IOException{
        JSONObject lastTradeHistory = userService.getLastTradeHistory();
        return new ResponseEntity<>(lastTradeHistory, HttpStatus.OK);
    }

    @GetMapping("/balance")
    private ResponseEntity<String> getCurrencyBalance(@RequestParam @NotNull String symbol) throws IOException{
        String currencyBalance = userService.getBalance(symbol);
        return new ResponseEntity<>(currencyBalance, HttpStatus.OK);
    }

    @GetMapping("/balance/btc")
    private ResponseEntity<String> getBTCBalance(@RequestHeader("authorization") String API) throws IOException{
        String btcBalance = userService.getBTCBalance();
        return new ResponseEntity<>(btcBalance, HttpStatus.OK);
    }

    @GetMapping("/balance/usdt")
    private ResponseEntity<String> getUSDTBalance(@RequestHeader("authorization") String API) throws IOException{
        String usdtBalance = userService.getUSDTBalance();
        return new ResponseEntity<>(usdtBalance, HttpStatus.OK);
    }

    @GetMapping("/balance/eth")
    private ResponseEntity<String> getETHBalance(@RequestHeader("authorization") String API) throws IOException{
        String ethBalance = userService.getETHBalance();
        return new ResponseEntity<>(ethBalance, HttpStatus.OK);
    }
}
