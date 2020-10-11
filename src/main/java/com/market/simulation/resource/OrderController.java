package com.market.simulation.resource;

import com.market.simulation.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for {@link com.market.simulation.domain.User} class.
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

}
