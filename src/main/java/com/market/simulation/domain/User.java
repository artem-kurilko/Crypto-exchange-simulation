package com.market.simulation.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * Class that represents user
 *
 * @author Artemii Kurilko
 * @version 1.0
 */

@Getter
@Setter
@Entity
@AllArgsConstructor
public class User extends BaseEntity{

    private String name;

    private String key;

    private float btcBalance;

    private float usdtBalance;

}
