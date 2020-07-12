package com.market.simulation.resource;

import com.market.simulation.repository.UserRepository;
import com.market.simulation.service.OrdersService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.io.IOException;

@RestController
@RequestMapping("http://localhost:8080")
public class UserController {

    private final OrdersService ordersService;
    private final UserRepository userRepository;

    @Autowired
    public UserController(OrdersService ordersService, UserRepository userRepository) {
        this.ordersService = ordersService;
        this.userRepository = userRepository;
    }

    @GetMapping("/active-orders")
    private ResponseEntity<JSONArray> getActiveOrders(){

    }

    @GetMapping("/order-history")
    private ResponseEntity<JSONArray> getOrdersHistory(){

    }

    @PostMapping("/create")
    private ResponseEntity placeOrder(@RequestParam @NotNull String side,
                                       @RequestParam @NotNull String quantity,
                                       @RequestParam @NotNull String price,
                                       @RequestParam @NotNull String symbol) throws IOException {

        ordersService.createOrder(symbol, side, quantity, price);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    private ResponseEntity cancelOrder(@RequestParam @NotNull Long id) throws IOException{
        ordersService.cancelOrder(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
