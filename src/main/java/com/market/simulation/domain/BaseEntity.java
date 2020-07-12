package com.market.simulation.domain;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class BaseEntity {

    @Id()
    private Long id;
}
