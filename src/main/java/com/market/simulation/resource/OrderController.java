package com.market.simulation.resource;

import com.market.simulation.exception.UserNotFoundException;
import com.market.simulation.services.OrderServiceImpl;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

import static java.lang.Float.parseFloat;
import static java.lang.Long.parseLong;

/**
 * REST controller for {@link com.market.simulation.domain.Order} class.
 *
 * @author Kurilko Artemii
 * @version 1.0
 */
@RestController
public class OrderController {

    private final OrderServiceImpl orderService;

    @Autowired
    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public void placeOrder(@RequestParam @NotNull String userId,
                           @RequestParam @NotNull boolean isBuy,
                           @RequestParam @NotNull String side,
                           @RequestParam @NotNull String price,
                           @RequestParam @NotNull String quantity) throws UserNotFoundException {
        orderService.placeOrder(parseLong(userId), isBuy, side, parseFloat(price), parseFloat(quantity));
    }

    @DeleteMapping("/order")
    public void cancelOrder(@RequestParam @NotNull Long userId,
                            @RequestParam @NotNull Long orderId) throws UserNotFoundException {
        orderService.cancelOrder(userId, orderId, false);
    }

    @GetMapping("/order")
    public ResponseEntity<JSONArray> getActiveOrders(Long userId){
        return new ResponseEntity<>(orderService.getActiveOrders(userId), HttpStatus.OK);
    }

    @GetMapping("/ordersHistory")
    public ResponseEntity<JSONArray> getOrdersHistory(Long userId){
        return new ResponseEntity<>(orderService.getOrdersHistory(userId), HttpStatus.OK);
    }

}
