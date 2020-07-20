package com.market.simulation.repository;

import com.market.simulation.domain.ActiveOrders;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link com.market.simulation.domain.ActiveOrders} class.
 *
 * @author Kurilko Artemii
 * @version 1.0
 */

@Repository
public interface ActiveOrdersRepository extends MongoRepository<ActiveOrders, Long> {

    @Query("{ 'clientOrderId' : ?0 }")
    ActiveOrders findByClientOrderId(String clientOrderId);
}
