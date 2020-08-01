package com.market.simulation.domain.orderstream;

import com.market.simulation.service.orderstream.BinanceApiWebSocketClient;
import com.market.simulation.service.orderstream.BinanceApiWebSocketClientImpl;

import static com.market.simulation.domain.User.getSharedClient;

/**
 * A factory for creating BinanceApi client objects.
 */
public class BinanceApiClientFactory {

    /**
     * API Key
     */
    private String apiKey;

    /**
     * Secret.
     */
    private String secret;

    /**
     * Instantiates a new binance api client factory.
     *
     * @param apiKey the API key
     * @param secret the Secret
     */
    private BinanceApiClientFactory(String apiKey, String secret) {
        this.apiKey = apiKey;
        this.secret = secret;
    }

    /**
     * New instance.
     *
     * @param apiKey the API key
     * @param secret the Secret
     *
     * @return the binance api client factory
     */
    public static BinanceApiClientFactory newInstance(String apiKey, String secret) {
        return new BinanceApiClientFactory(apiKey, secret);
    }

    /**
     * New instance without authentication.
     *
     * @return the binance api client factory
     */
    public static BinanceApiClientFactory newInstance() {
        return new BinanceApiClientFactory(null, null);
    }

    /**
     * Creates a new web socket client used for handling data streams.
     */
    public BinanceApiWebSocketClient newWebSocketClient() {
        return new BinanceApiWebSocketClientImpl(getSharedClient());
    }
}

