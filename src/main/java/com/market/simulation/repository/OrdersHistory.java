package com.market.simulation.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link OrdersHistory} class.
 *
 * @author Kurilko Artemii
 * @version 1.0
 */

@Repository
public interface OrdersHistory extends MongoRepository<OrdersHistory, Long> {
}
