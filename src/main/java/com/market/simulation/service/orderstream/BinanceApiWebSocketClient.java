package com.market.simulation.service.orderstream;

import com.market.simulation.domain.orderstream.AggTradeEvent;

import java.io.Closeable;

/**
 * Binance API data streaming facade, supporting streaming of events through web sockets.
 */
public interface BinanceApiWebSocketClient extends Closeable {

    /**
     * Open a new web socket to receive {@link AggTradeEvent aggTradeEvents} on a callback.
     *
     * @param symbols   market (one or coma-separated) symbol(s) to subscribe to
     * @param callback  the callback to call on new events
     * @return a {@link Closeable} that allows the underlying web socket to be closed.
     */
    Closeable onAggTradeEvent(String symbols, BinanceApiCallback<AggTradeEvent> callback);


    /**
     * @deprecated This method is no longer functional. Please use the returned {@link Closeable} from any of the other methods to close the web socket.
     */
    @Deprecated
    void close();
}
