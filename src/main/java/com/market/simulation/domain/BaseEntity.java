package com.market.simulation.domain;

import lombok.Getter;

import javax.persistence.MappedSuperclass;

/**
 * Base class class with property ID.
 *
 * @author Artemii Kurilko
 * @version 1.0
 */

@MappedSuperclass
@Getter
public abstract class BaseEntity {

    private Long id;

}
