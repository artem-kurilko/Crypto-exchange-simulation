package com.market.simulation.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

/**
 * Class class with property ID.
 *
 * @author Artemii Kurilko
 * @version 1.0
 */


@Entity
@Table(name = "")
public class Order extends BaseEntity{

    private String symbol;

    private String side;

    private String quantity;

    private String price;

    // order create time
    private Instant createdAt;

    private String cumQuantity;
}
