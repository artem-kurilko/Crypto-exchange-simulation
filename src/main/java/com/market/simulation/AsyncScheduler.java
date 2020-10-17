package com.market.simulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * A simple java class for executing async process,
 * is used for matching user's active orders with real active orders from binance.
 *
 * @author Artemii Kurilko
 * @version 1.0
 */

@Component("scheduledAnnotationExample")
public class AsyncScheduler {
    private final OrderMatchingEngine matchingEngine;

    @Autowired
    public AsyncScheduler(OrderMatchingEngine matchingEngine) {
        this.matchingEngine = matchingEngine;
    }

    /*@Scheduled(fixedDelay = 5000)
    public void scheduleFixedDelayTask() throws IOException {
        matchingEngine.matchOrders();
        System.out.println("Fixed delay task - " + System.currentTimeMillis() / 1000);
    }
*/
}
