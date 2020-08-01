package com.market.simulation.resource;

import com.market.simulation.service.OrderServiceImpl;
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
 * REST controller for {@link com.market.simulation.domain.User} class.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

@RestController
@RequestMapping("http://localhost:8080")
public class UserController {

    private final OrderServiceImpl orderService;
    private final UserServiceImpl userService;

    @Autowired
    public UserController(OrderServiceImpl orderService, UserServiceImpl userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/active-orders")
    public ResponseEntity<JSONArray> getActiveOrders(@RequestHeader("authorization") @NotNull String API) throws IOException{
        JSONArray activeOrders = userService.getActiveOrders(API);
        return new ResponseEntity<>(activeOrders, HttpStatus.OK);
    }

    @GetMapping("/active-orders/last")
    public ResponseEntity<JSONObject> getLastActiveOrder(@RequestHeader("authorization") @NotNull String API) throws IOException{
        JSONObject lastActiveOrder = userService.getLastActiveOrder(API);
        return new ResponseEntity<>(lastActiveOrder, HttpStatus.OK);
    }

    @GetMapping("/order-history")
    public ResponseEntity<JSONArray> getTradeHistory(@RequestHeader("authorization") @NotNull String API) throws IOException{
        JSONArray tradeHistory = userService.getTradeHistory(API);
        return new ResponseEntity<>(tradeHistory, HttpStatus.OK);
    }

    @GetMapping("/order-history/last")
    public ResponseEntity<JSONObject> getLastTradeHistory(@RequestHeader("authorization") @NotNull String API) throws IOException{
        JSONObject lastTradeHistory = userService.getLastTradeHistory(API);
        return new ResponseEntity<>(lastTradeHistory, HttpStatus.OK);
    }

    @GetMapping("/balance")
    public ResponseEntity<String> getCurrencyBalance(@RequestHeader("authorization") @NotNull String API, @RequestParam @NotNull String symbol) throws IOException{
        String currencyBalance = userService.getBalance(API, symbol);
        return new ResponseEntity<>(currencyBalance, HttpStatus.OK);
    }

    @GetMapping("/balance/btc")
    public ResponseEntity<String> getBTCBalance(@RequestHeader("authorization") @NotNull String API) throws IOException{
        String btcBalance = userService.getBTCBalance(API);
        return new ResponseEntity<>(btcBalance, HttpStatus.OK);
    }

    @GetMapping("/balance/usdt")
    public ResponseEntity<String> getUSDTBalance(@RequestHeader("authorization") @NotNull String API) throws IOException{
        String usdtBalance = userService.getUSDTBalance(API);
        return new ResponseEntity<>(usdtBalance, HttpStatus.OK);
    }

    @GetMapping("/balance/eth")
    public ResponseEntity<String> getETHBalance(@RequestHeader("authorization") @NotNull String API) throws IOException{
        String ethBalance = userService.getETHBalance(API);
        return new ResponseEntity<>(ethBalance, HttpStatus.OK);
    }
}
