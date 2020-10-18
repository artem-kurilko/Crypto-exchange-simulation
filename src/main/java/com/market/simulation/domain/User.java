package com.market.simulation.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Class that represents user.
 *
 * @author Artemii Kurilko
 * @version 1.0
 * @see com.market.simulation.repository.UserRepository
 * @see com.market.simulation.services.UserServiceImpl
 */

@Getter
@Setter
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "btc_balance_free")
    private float btcBalanceFree;

    @NotNull
    @Column(name = "btc_balance_reserved")
    private float btcBalanceReserved;

    @NotNull
    @Column(name = "usdt_balance_free")
    private float usdtBalanceFree;

    @NotNull
    @Column(name = "usdt_balance_reserved")
    private float usdtBalanceReserved;

}
