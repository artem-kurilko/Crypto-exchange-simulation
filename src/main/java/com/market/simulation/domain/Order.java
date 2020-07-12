package com.market.simulation.domain;

import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

/**
 * Class class with property ID.
 *
 * @author Artemii Kurilko
 * @version 1.0
 */


@Entity
@Table(name = "")
@AllArgsConstructor
public class Order extends BaseEntity{

    @NotNull
    private String symbol;

    @NotNull
    @Size(min = 3, max = 4)
    private String side;

    @NotNull
    private String quantity;

    @NotNull
    private String price;

    @NotNull
    // order create time
    private Instant createdAt;

    @NotNull
    private String cumQuantity;

    @NotNull
    private String status;
}
