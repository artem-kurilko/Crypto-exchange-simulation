package com.market.simulation.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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

    @Field("clientOrderId")
    private Long clientOrderId;

    @Field("symbol")
    private String symbol;

    @Field("side")
    private String side;

    @Field("status")
    private String status;

    @Field("quantity")
    private float quantity;

    @Field("price")
    private float price;

    @Field("cumQuantity")
    private float cumQuantity;

    @Field("createAt")
    private Long createdAt;

}
