package com.market.simulation.services.orderstream;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.market.simulation.exception.UserNotFoundException;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

import java.io.IOException;

/**
 * Binance API WebSocket listener.
 *
 * @author Artemii Kurilko
 * @version 1.0
 * @see com.market.simulation.services.orderstream.BinanceApiWebSocketClientImpl
 */

public class BinanceApiWebSocketListener<T> extends WebSocketListener {
    private BinanceApiCallback<T> callback;
    private static final ObjectMapper mapper = new ObjectMapper();
    private final ObjectReader objectReader;
    private boolean closing = false;

    public BinanceApiWebSocketListener(BinanceApiCallback<T> callback, Class<T> eventClass) {
        this.callback = callback;
        this.objectReader = mapper.readerFor(eventClass);
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        try {
            T event = objectReader.readValue(text);
            callback.onResponse(event);
        } catch (IOException | UserNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClosing(final WebSocket webSocket, final int code, final String reason) {
        closing = true;
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        if (!closing) {
            callback.onFailure(t);
        }
    }

}