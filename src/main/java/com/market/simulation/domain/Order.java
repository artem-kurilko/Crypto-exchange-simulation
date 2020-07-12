package com.market.simulation.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "")
@Getter
@Setter
public class Order extends BaseEntity{

    private String symbol;

    private String side;

    private String quantity;

    private String price;

    // order create time
    private Instant createdAt;

    private String cumQuantity;
}
