package com.market.simulation.controller;

import com.market.simulation.service.OrdersServiceImpl;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("http://localhost:8080")
public class OrdersController {
    private OrdersServiceImpl ordersService;

    @Autowired
    public OrdersController(OrdersServiceImpl ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping("/create")
    private ResponseEntity createOrder(@RequestParam @NotNull String side,
                             @RequestParam @NotNull String quantity,
                             @RequestParam @NotNull String price,
                             @RequestParam @NotNull String currencyPair){

        ordersService.placeOrder(side, quantity, price, currencyPair);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/average-price")
    private ResponseEntity<String> getAveragePrice(@RequestParam @NotNull String currencyPair){
        String averagePrice = ordersService.getAveragePrice(currencyPair);
        return new ResponseEntity<>(averagePrice, HttpStatus.OK);
    }

    @GetMapping(value = "/open-orders", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<JSONArray> getOpenOrders(){
        JSONArray openOrders = ordersService.getOpenOrders();
        return new ResponseEntity(openOrders, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    private ResponseEntity deleteOrder(@RequestParam String clientOrderId){
        ordersService.cancelOrder(clientOrderId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
