package com.market.simulation.repository;

import com.market.simulation.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link com.market.simulation.domain.User} class.
 *
 * @author Kurilko Artemii
 * @version 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
