package com.market.simulation.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class that represents user's active order
 *
 * @author Artemii Kurilko
 * @version 1.0
 */

@Document(collection = "product")
public class ActiveOrders extends Order {

    public ActiveOrders(Long userId, String clientOrderId, String symbol, String side, String quantity, String price, String createdAt, String cumQuantity, String status) {
        super(userId, clientOrderId, symbol, side, quantity, price, createdAt, cumQuantity, status);
    }
}
