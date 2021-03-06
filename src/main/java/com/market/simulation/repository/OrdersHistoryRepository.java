package com.market.simulation.repository;

import com.market.simulation.domain.OrderHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link OrderHistory} class.
 *
 * @author Kurilko Artemii
 * @version 1.0
 * @see com.market.simulation.services.OrderServiceImpl
 */
@Repository
public interface OrdersHistoryRepository extends MongoRepository<OrderHistory, Long> {
}
