package com.market.simulation.repository;

import com.market.simulation.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link User} class.
 *
 * @author Kurilko Artemii
 * @version 1.0
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.key = ?1")
    User findUserByKey(String key);

}
