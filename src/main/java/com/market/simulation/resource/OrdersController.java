package com.market.simulation.resource;

import com.market.simulation.service.OrdersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.io.IOException;

@RestController
@RequestMapping("http://localhost:8080")
public class OrdersController {
    private final OrdersServiceImpl ordersService;

    @Autowired
    public OrdersController(OrdersServiceImpl ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("/average-price")
    private ResponseEntity<String> getAveragePrice(@RequestParam @NotNull String symbol) throws IOException {
        String averagePrice = ordersService.getAveragePrice(symbol);
        return new ResponseEntity<>(averagePrice, HttpStatus.OK);
    }
}
