package com.market.simulation;

import com.market.simulation.domain.BookTickerEvent;
import com.market.simulation.exception.UserNotFoundException;
import com.market.simulation.services.OrderServiceImpl;
import com.market.simulation.services.orderstream.BinanceApiCallback;
import com.market.simulation.services.orderstream.BinanceApiWebSocketClient;
import com.market.simulation.services.orderstream.BinanceApiWebSocketClientImpl;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Java class for matching user's active orders with binance order book.
 *
 * @author Artemii Kurilko
 * @version 1.0
 */

@Component
public class OrderMatchingEngine {
    private static final OkHttpClient sharedClient;
    private static final String symbol = "btcusdt";
    private final OrderServiceImpl orderService;

    @Autowired
    public OrderMatchingEngine(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    static {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(500);
        dispatcher.setMaxRequests(500);
        sharedClient = new OkHttpClient.Builder()
                .dispatcher(dispatcher)
                .pingInterval(20, TimeUnit.SECONDS)
                .build();
    }

    // TODO: create orders matching
    // FIXME: understand if active orders iterator starts with the oldest order
    public void matchOrders() throws IOException {
        BinanceApiWebSocketClient client =  new BinanceApiWebSocketClientImpl(getSharedClient());

        client.onBookTickerEvent(symbol.toLowerCase(), new BinanceApiCallback<BookTickerEvent>() {
            @Override
            public void onResponse(BookTickerEvent response) throws UserNotFoundException {
                JSONArray activeOrders = orderService.getActiveOrders(1L);
                for (int i = 0; i < activeOrders.length(); i++){
                    JSONObject activeOrder = activeOrders.getJSONObject(i);

                    if (activeOrder.getString("side").equals("buy")){
                        if (activeOrder.getString("price").equals(response.getAskPrice()) && activeOrder.getString("quantity").equals(response.getAskQuantity()))
                            orderService.executeActiveOrder(activeOrder.getLong("clientOrderId"), activeOrder.getLong("_id"));
                    } else if (activeOrder.getString("side").equals("sell")){
                        if (activeOrder.getString("price").equals(response.getBidPrice()) && activeOrder.getString("quantity").equals(response.getBidQuantity()))
                            orderService.executeActiveOrder(activeOrder.getLong("clientOrderId"), activeOrder.getLong("_id"));
                    }
                }
            }

            @Override
            public void onFailure(final Throwable cause){
                cause.printStackTrace();
            }
        });

        Closeable ws = client.onBookTickerEvent(symbol, new BinanceApiCallback<BookTickerEvent>() {
            @Override
            public void onResponse(BookTickerEvent response) {}

            @Override
            public void onFailure(final Throwable cause){
                cause.printStackTrace();
            }
        });

        ws.close();
    }

    /**
     * Returns the shared OkHttpClient instance.
     */
    private static OkHttpClient getSharedClient() {
        return sharedClient;
    }

}