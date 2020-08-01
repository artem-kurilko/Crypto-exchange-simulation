package com.market.simulation.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class that represents orders history
 *
 * @author Artemii Kurilko
 * @version 1.0
 */

@Document(collection = "product")
public class OrdersHistory extends Order{
    public OrdersHistory(Long userId, String clientOrderId, String symbol, String side, String quantity, String price, String createdAt, String cumQuantity, String status) {
        super(userId, clientOrderId, symbol, side, quantity, price, createdAt, cumQuantity, status);
    }
}
