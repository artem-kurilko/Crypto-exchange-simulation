package com.market.simulation.repository;

import com.market.simulation.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link com.market.simulation.domain.Order} class.
 *
 * @author Kurilko Artemii
 * @version 1.0
 * @see com.market.simulation.services.OrderServiceImpl
 */

@Repository
public interface OrderRepository extends MongoRepository<Order, Long> {

}
