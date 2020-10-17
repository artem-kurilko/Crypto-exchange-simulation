package com.market.simulation.domain;

/**
 * Interface for {@link com.market.simulation.domain.Order} status.
 *
 * @author Artemii Kurilko
 * @version 1.0
 */

public interface OrderStatus {
    String NEW = "new",
    PARTIALLY_FILLED = "partially filled",
    FILLED = "filled",
    CANCELED = "canceled";
}
