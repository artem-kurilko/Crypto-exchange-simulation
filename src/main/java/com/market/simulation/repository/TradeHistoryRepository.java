package com.market.simulation.repository;

import com.market.simulation.domain.TradeHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link com.market.simulation.domain.TradeHistory} class.
 *
 * @author Kurilko Artemii
 * @version 1.0
 */

@Repository
public interface TradeHistoryRepository extends MongoRepository<TradeHistory, Long> {
}
