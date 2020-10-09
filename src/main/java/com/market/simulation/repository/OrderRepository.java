package com.market.simulation.repository;

import com.market.simulation.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link Order} class.
 *
 * @author Kurilko Artemii
 * @version 1.0
 */

@Repository
public interface OrderRepository extends MongoRepository<Order, Long> {

    @Query("{ 'clientOrderId' : ?0 }")
    Order findByClientOrderId(String clientOrderId);
}
