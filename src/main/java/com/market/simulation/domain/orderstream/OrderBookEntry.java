package com.market.simulation.domain.orderstream;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * An order book entry consisting of price and quantity.
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderBookEntry {

    private String price;
    private String qty;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("price", price)
                .append("qty", qty)
                .toString();
    }
}
