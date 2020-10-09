package com.market.simulation.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;

/**
 * Class that represents user's order
 *
 * @author Artemii Kurilko
 * @version 1.0
 */

@Getter
@Setter
@Document(collection="order")
public class Order extends BaseEntity{

    @NotNull
    @Field(value = "user_id")
    Long userId;

    @NotNull
    @Field(value = "client_order_id")
    String clientOrderId;

    @NotNull
    @Field(value = "symbol")
    String symbol;

    @NotNull
    @Field(value = "side")
    String side;

    @NotNull
    @Field(value = "quantity")
    String quantity;

    @NotNull
    @Field(value = "price")
    String price;

    @NotNull
    @Field(value = "created_at")
    String createdAt;

    @NotNull
    @Field(value = "cum_quantity")
    String cumQuantity;

    @NotNull
    @Field(value = "status")
    String status;

    public Order(Long userId, String clientOrderId, String symbol, String side, String quantity, String price, String createdAt, String cumQuantity, String status) {
        this.userId = userId;
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
