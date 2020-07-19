package com.market.simulation.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;

/**
 * Class that represents user order
 *
 * @author Artemii Kurilko
 * @version 1.0
 */

@Getter
@Setter
@Document(collection="order")
public class Order extends BaseEntity{

    @NotNull
    @Field(value = "client_order_id")
    private String clientOrderId;

    @NotNull
    @Field(value = "symbol")
    private String symbol;

    @NotNull
    @Field(value = "side")
    private String side;

    @NotNull
    @Field(value = "quantity")
    private String quantity;

    @NotNull
    @Field(value = "price")
    private String price;

    @NotNull
    @Field(value = "created_at")
    private String createdAt;

    @NotNull
    @Field(value = "cum_quantity")
    private String cumQuantity;

    @NotNull
    @Field(value = "status")
    private String status;

    public Order(String clientOrderId, String symbol, String side, String quantity, String price, String createdAt, String cumQuantity, String status) {
        this.clientOrderId = clientOrderId;
        this.symbol = symbol;
        this.side = side;
        this.quantity = quantity;
        this.price = price;
        this.createdAt = createdAt;
        this.cumQuantity = cumQuantity;
        this.status = status;
    }
}
