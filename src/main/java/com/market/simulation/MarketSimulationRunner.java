package com.market.simulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * Java class to run crypto market simulation app.
 *
 * @author Kurilko Artemii
 * @version 1.0
 */

@SpringBootApplication
public class MarketSimulationRunner {
    private static OrderMatchingEngine matchingEngine;

    @Autowired
    public MarketSimulationRunner(OrderMatchingEngine matchingEngine){
        MarketSimulationRunner.matchingEngine = matchingEngine;
    }

    public static void main(String[] args) throws IOException {
        SpringApplication.run(MarketSimulationRunner.class);
        matchingEngine.matchOrders();
    }
}
