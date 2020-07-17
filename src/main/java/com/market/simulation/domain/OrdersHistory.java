package com.market.simulation.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class that represents orders history
 *
 * @author Artemii Kurilko
 * @version 1.0
 */

@Document(collection = "product")
public class OrdersHistory extends Order{
}
