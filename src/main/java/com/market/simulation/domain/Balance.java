package com.market.simulation.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;

/**
 * Class that represents user's balance
 *
 * @author Kurilko Artemii
 * @version 1.0
 */

@Getter
@Setter
@Document(collection = "balance")
public class Balance extends BaseEntity {

    @NotNull
    @Field(value = "user_id")
    private Long userId;

    @NotNull
    @Field(value = "currency")
    private String currency;

    @NotNull
    @Field(value = "available")
    private int available;

    @NotNull
    @Field(value = "reserved")
    private int reserved;
}
