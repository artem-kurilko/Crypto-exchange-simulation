package com.market.simulation.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Class that represents user
 *
 * @author Artemii Kurilko
 * @version 1.0
 */


@Getter
@Setter
@Entity
@Table(name = "user")
public class User extends BaseEntity{

    @NotNull
    @Column(name = "key")
    private String key;

    @NotNull
    @Column
    private String balance;
}
