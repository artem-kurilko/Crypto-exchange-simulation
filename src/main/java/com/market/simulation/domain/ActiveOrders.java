package com.market.simulation.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Class that represents user's active order
 *
 * @author Artemii Kurilko
 * @version 1.0
 */

@Document(collection = "product")
public class ActiveOrders extends Order {

}
