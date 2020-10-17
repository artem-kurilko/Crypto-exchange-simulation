package com.market.simulation.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class that represents order.
 *
 * @author Artemii Kurilko
 * @version 1.0
 * @see com.market.simulation.repository.OrderRepository
 * @see com.market.simulation.services.OrderServiceImpl
 */

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "orders")
public class Order {

    private Long clientOrderId;

    private String symbol;

    private String side;

    private String status;

    private float quantity;

    private float price;

    private float cumQuantity;

    private Long createdAt;

}
