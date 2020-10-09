package com.market.simulation.resource;

import com.market.simulation.domain.User;
import com.market.simulation.exception.UserNotFoundException;
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
 * REST controller for {@link com.market.simulation.domain.Order} class.
 *
 * @author Kurilko Artemii
 * @version 1.0
 */

@RestController
@RequestMapping("http://localhost:8080")
public class OrderController {
    private final OrderServiceImpl ordersService;
    private final UserServiceImpl userService;

    @Autowired
    public OrderController(OrderServiceImpl ordersService, UserServiceImpl userService) {
        this.ordersService = ordersService;
        this.userService = userService;
    }

    /*@GetMapping("/active-orders")
    public ResponseEntity<JSONArray> getActiveOrders(@RequestHeader("authorization") @NotNull String API) throws IOException{
        JSONArray activeOrders = ;
        return new ResponseEntity<>(activeOrders, HttpStatus.OK);
    }

    @GetMapping("/active-orders/last")
    public ResponseEntity<JSONObject> getLastActiveOrder(@RequestHeader("authorization") @NotNull String API) throws IOException{
        JSONObject lastActiveOrder = ;
        return new ResponseEntity<>(lastActiveOrder, HttpStatus.OK);
    }

    @GetMapping("/order-history")
    public ResponseEntity<JSONArray> getTradeHistory(@RequestHeader("authorization") @NotNull String API) throws IOException{
        JSONArray tradeHistory = ;
        return new ResponseEntity<>(tradeHistory, HttpStatus.OK);
    }

    @GetMapping("/order-history/last")
    public ResponseEntity<JSONObject> getLastTradeHistory(@RequestHeader("authorization") @NotNull String API) throws IOException{
        JSONObject lastTradeHistory = userServiceImpl.getLastTradeHistory(API);
        return new ResponseEntity<>(lastTradeHistory, HttpStatus.OK);
    }*/

    @GetMapping("/average-price")
    public ResponseEntity<String> getAveragePrice(@RequestParam @NotNull String symbol) throws IOException {
        String averagePrice = ordersService.getAveragePrice(symbol);
        return new ResponseEntity<>(averagePrice, HttpStatus.OK);
    }

    /*@PostMapping("/create")
    public ResponseEntity placeOrder(@RequestHeader @NotNull String API,
                                     @RequestParam @NotNull String side,
                                     @RequestParam @NotNull String quantity,
                                     @RequestParam @NotNull String price,
                                     @RequestParam @NotNull String symbol) throws IOException, UserNotFoundException {

        User user = userService.getUserByKey(API);
        Long userId = user.getId();
        ordersService.createOrder(userId, API, symbol, side, quantity, price);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity cancelOrder(@RequestHeader @NotNull String API,
                                      @RequestParam @NotNull String clientOrderId) throws IOException, UserNotFoundException {

        User user = userService.getUserByKey(API);
        String userKey = user.getKey();
        ordersService.cancelOrder(userKey, clientOrderId);
        return new ResponseEntity(HttpStatus.OK);
    }*/
}
