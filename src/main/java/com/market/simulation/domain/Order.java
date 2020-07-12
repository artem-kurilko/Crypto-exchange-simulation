package com.market.simulation.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Class that represents user order
 *
 * @author Artemii Kurilko
 * @version 1.0
 */

@Entity
@Table(name = "user_order")
@Getter
@Setter
@ToString
public class Order extends BaseEntity{

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
}
