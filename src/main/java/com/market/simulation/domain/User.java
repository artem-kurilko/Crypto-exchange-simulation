package com.market.simulation.domain;

import com.market.simulation.service.orderstream.BinanceApiWebSocketClient;
import com.market.simulation.service.orderstream.BinanceApiWebSocketClientImpl;
import lombok.Getter;
import lombok.Setter;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.concurrent.TimeUnit;

/**
 * Class that represents user
 *
 * @author Artemii Kurilko
 * @version 1.0
 */

@Getter
@Setter
@Entity
@Table(name = "user")
public class User extends BaseEntity{

    @NotNull
    @Column(name = "key")
    private String key;

    private static final OkHttpClient sharedClient;

    static {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(500);
        dispatcher.setMaxRequests(500);
        sharedClient = new OkHttpClient.Builder()
                .dispatcher(dispatcher)
                .pingInterval(20, TimeUnit.SECONDS)
                .build();
    }

    public User(String key) {
        this.key = key;
    }

    /**
     * New instance without authentication.
     *
     * @return the User object
     */
    public static User newInstance() {
        return new User(null);
    }

    /**
     * Creates a new web socket client used for handling data streams.
     */
    public BinanceApiWebSocketClient newWebSocketClient() {
        return new BinanceApiWebSocketClientImpl(getSharedClient());
    }

    public static OkHttpClient getSharedClient() {
        return sharedClient;
    }
}
