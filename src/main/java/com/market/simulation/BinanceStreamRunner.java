package com.market.simulation;

import com.market.simulation.domain.orderstream.AggTradeEvent;
import com.market.simulation.domain.orderstream.BinanceApiClientFactory;
import com.market.simulation.services.orderstream.BinanceApiCallback;
import com.market.simulation.services.orderstream.BinanceApiWebSocketClient;

import java.io.Closeable;
import java.io.IOException;

public class BinanceStreamRunner {
    private static final String symbol = "btcusdt";

    public static void main(String[] args) throws IOException {
        BinanceApiWebSocketClient client = BinanceApiClientFactory.newInstance().newWebSocketClient();

        client.onAggTradeEvent(symbol.toLowerCase(), new BinanceApiCallback<AggTradeEvent>() {
            @Override
            public void onResponse(final AggTradeEvent response) {
                System.out.println("response: " + response);
            }

            @Override
            public void onFailure(final Throwable cause) {
                System.err.println("Web socket failed");
                cause.printStackTrace(System.err);
            }
        });

        Closeable ws = client.onAggTradeEvent(symbol, (AggTradeEvent response) -> {
            System.out.println(response.getPrice());
            System.out.println(response.getQuantity());
        });

        ws.close();
    }
}
