package com.market.simulation.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Class that represents user order
 *
 * @author Artemii Kurilko
 * @version 1.0
 */

@Getter
@Setter
public class Order extends BaseEntity{

    @NotNull
    @Column(name = "client_order_id")
    private Long clientOrderId;

    @NotNull
    @Column(name = "symbol")
    private String symbol;

    @NotNull
    @Size(min = 3, max = 4)
    @Column(name = "side")
    private String side;

    @NotNull
    @Column(name = "quantity")
    private String quantity;

    @NotNull
    @Column(name = "price")
    private String price;

    @NotNull
    @Column(name = "created_at")
    private String createdAt;

    @NotNull
    @Column(name = "cum_quantity")
    private String cumQuantity;

    @NotNull
    @Column(name = "status")
    private String status;

    public Order(String symbol, String side, String quantity, String price, String createdAt, String cumQuantity, String status) {
        this.symbol = symbol;
        this.side = side;
        this.quantity = quantity;
        this.price = price;
        this.createdAt = createdAt;
        this.cumQuantity = cumQuantity;
        this.status = status;
    }

}
