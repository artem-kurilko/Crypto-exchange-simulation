package com.market.simulation.domain;

public interface OrderStatus {
    String NEW = "new",
    PARTIALLY_FILLED = "partially filled",
    FILLED = "filled",
    CANCELED = "canceled";
}
