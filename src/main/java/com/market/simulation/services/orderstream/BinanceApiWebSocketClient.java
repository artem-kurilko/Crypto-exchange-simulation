package com.market.simulation.services.orderstream;

import com.market.simulation.domain.BookTickerEvent;

import java.io.Closeable;

/**
 * Binance API data streaming facade, supporting streaming of events through web sockets.
 *
 * @author Artemii Kurilko
 * @version 1.0
 */
public interface BinanceApiWebSocketClient extends Closeable {

    /**
     * Open a new web socket to receive {@link BookTickerEvent bookTickerEvents} on a callback.
     *
     * @param symbols   market (one or coma-separated) symbol(s) to subscribe to
     * @param callback  the callback to call on new events
     * @return a {@link Closeable} that allows the underlying web socket to be closed.
     */
    Closeable onBookTickerEvent(String symbols, BinanceApiCallback<BookTickerEvent> callback);

    /**
     * @deprecated This method is no longer functional. Please use the returned {@link Closeable} from any of the other methods to close the web socket.
     */
    @Deprecated
    void close();

}
