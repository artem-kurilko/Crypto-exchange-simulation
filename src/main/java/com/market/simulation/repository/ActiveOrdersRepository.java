package com.market.simulation.repository;

import com.market.simulation.domain.ActiveOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link ActiveOrder} class.
 *
 * @author Kurilko Artemii
 * @version 1.0
 * @see com.market.simulation.services.OrderServiceImpl
 */

@Repository
public interface ActiveOrdersRepository extends MongoRepository<ActiveOrder, Long> {

}
