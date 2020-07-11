package com.market.simulation.controller;

import com.market.simulation.service.OrdersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("http://localhost:8080")
public class OrdersController {
    private OrdersServiceImpl ordersService;

    @Autowired
    public OrdersController(OrdersServiceImpl ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping("/create")
    private void createOrder(@RequestParam String side,
                             @RequestParam String quantity,
                             @RequestParam String price,
                             @RequestParam String currencyPair){

        ordersService.placeOrder(true);
    }

    @DeleteMapping("/delete")
    private void deleteOrder(@RequestParam String clientOrderId){
        ordersService.cancelOrder(clientOrderId);
    }
}
