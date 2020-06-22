package com.enaz.bitazza.socket;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

/**
 * Created by eduardo.delito on 6/22/20.
 */
public class WebSocketOnSubscribe extends WebSocketListener {
    @Override
    public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
        System.out.println("onOpen=========="+response.isSuccessful());

    }

    @Override
    public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable t, @Nullable Response response) {
        super.onFailure(webSocket, t, response);
        System.out.println("onFailure=========="+t.getMessage());
    }

    @Override
    public void onClosing(@NotNull WebSocket webSocket, int code, @NotNull String reason) {
        super.onClosing(webSocket, code, reason);
        webSocket.close(1000, null);
        System.out.println("onClosing=========="+reason);
    }

    @Override
    public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
        super.onMessage(webSocket, text);
        System.out.println("text========="+text);
    }
}
