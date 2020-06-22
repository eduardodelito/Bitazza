package com.enaz.bitazza.socket;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

/**
 * Created by eduardo.delito on 6/22/20.
 */
public class SSSocketHandler extends WebSocketListener {
    public static final int NORMAL_CLOSURE_STATUS = 1000;
    private Context mContext;
    private OkHttpClient mClient;

    public SSSocketHandler(Context context, OkHttpClient client) {
        this.mContext = context;
        this.mClient = client;
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        Log.d("socket","Socket open sesame!");
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        try {
            SSocketModelMain model = new Gson().fromJson(text, SSocketModelMain.class);
            SSSocketCore.getInstance().getSocketListener(mContext).onSocketMessage(model.getMessage());
            SSSocketCore.getInstance().getSubSocketListener(mContext).onSocketMessage(model.getMessage());
            //not reliable
            for (SSSocketListener listener : SSSocketCore.getInstance().getSocketListeners(mContext)) {
                listener.onSocketMessage(model.getMessage());
            }
        } catch (Exception e) {
//            e.printStackTrace();
        }

        String welcome = "{\"type\":\"welcome\"}";
        if (welcome.compareToIgnoreCase(text)==0) {
            try {
                JSONObject jsonMain = new JSONObject();
                JSONObject jsonSub = new JSONObject();
                jsonSub.put("channel","ApplicationCable::AppearanceChannel");
                jsonMain.put("identifier", jsonSub.toString());
                jsonMain.put("command","subscribe");
                webSocket.send(jsonMain.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onMessage(WebSocket webSocket, ByteString bytes) {
        Log.d("socket", "Receiving bytes : " + bytes.hex());
    }

    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
        webSocket.close(NORMAL_CLOSURE_STATUS, null);
        Log.d("socket", "Closing : " + code + " / " + reason);
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        Log.d("socket", "Error : " + t.getMessage());
        Log.d("socket", "Error : " + t.getCause());
        Log.d("socket", "Error : " + t.getLocalizedMessage());
        t.printStackTrace();
        mClient.dispatcher().executorService().shutdown();
    }
}

