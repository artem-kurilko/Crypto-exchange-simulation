package com.market.simulation.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * BookTickerEvent event for a symbol. Pushes any update to the best bid or
 * ask's price or quantity in real-time for a specified symbol.
 *
 * @author Artemii Kurilko
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookTickerEvent {

    @JsonProperty("u")
    private long updateId;

    @JsonProperty("s")
    private String symbol;

    @JsonProperty("b")
    private String bidPrice;

    @JsonProperty("B")
    private String bidQuantity;

    @JsonProperty("a")
    private String askPrice;

    @JsonProperty("A")
    private String askQuantity;

    public BookTickerEvent(String symbol, String bidPrice, String bidQuantity, String askPrice, String askQuantity) {
        super();
        this.symbol = symbol;
        this.bidPrice = bidPrice;
        this.bidQuantity = bidQuantity;
        this.askPrice = askPrice;
        this.askQuantity = askQuantity;
    }

}
