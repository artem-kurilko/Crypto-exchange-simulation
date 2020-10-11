package com.market.simulation.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * Class that represents order
 *
 * @author Artemii Kurilko
 * @version 1.0
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Order extends BaseEntity {

    private String clientOrderId;

    private String symbol;

    private String side;

    private String status;

    private String quantity;

    private String price;

    private String cumQuantity;

    private String createdAt;

}
