package com.market.simulation.domain;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONArray;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "")
@Getter
@Setter
public class User extends BaseEntity{

    private String key;

    private JSONArray openOrders;

    private JSONArray activeOrders;

    private String balance;
}
