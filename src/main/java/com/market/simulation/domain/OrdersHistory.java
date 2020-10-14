package com.market.simulation.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * A simple java class that represents active orders,
 * which extends {@link com.market.simulation.domain.Order} class.
 *
 * @author Artemii Kurilko
 * @version 1.0
 */

@Document(collection = "ordersHistory")
public class OrdersHistory extends Order {

    public OrdersHistory(Long clientOrderId, String symbol, String side, String status, float quantity, float price, float cumQuantity, Long createdAt) {
        super(clientOrderId, symbol, side, status, quantity, price, cumQuantity, createdAt);
    }

}
