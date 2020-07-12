package com.market.simulation.repository;

import com.market.simulation.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link Order} class.
 *
 * @author Kurilko Artemii
 * @version 1.0
 */

@Repository
public interface OrdersRepository extends JpaRepository<Order, Long> {

}
