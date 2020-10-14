package com.market.simulation.repository;

import com.market.simulation.domain.ActiveOrders;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link com.market.simulation.domain.ActiveOrders} class.
 *
 * @author Kurilko Artemii
 * @version 1.0
 * @see com.market.simulation.services.OrderServiceImpl
 */

@Repository
public interface ActiveOrdersRepository extends MongoRepository<ActiveOrders, Long> {

}
