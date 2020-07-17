package com.market.simulation.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class that represents user's trade history
 *
 * @author Artemii Kurilko
 * @version 1.0
 */

@Document(collection = "product")
public class TradeHistory extends Order{
}
