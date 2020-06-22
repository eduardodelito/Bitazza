package com.enaz.bitazza.socket;

import android.content.Context;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by eduardo.delito on 6/22/20.
 */
public class SSSocketCore {
    private static SSSocketCore sSocketInstance;
    private static List<SSSocketListener> sSocketRegisteredListeners;
    private SSSocketListener mSocketListener;
    private SSSocketListener mSubSocketListener;

    public static void init(Context context) {
        getInstance().onCreate(context);
    }

    private void onCreate(Context context) {
    }

    public synchronized static SSSocketCore getInstance() {
        if (sSocketInstance == null) {
            sSocketInstance = new SSSocketCore();
            sSocketRegisteredListeners = new CopyOnWriteArrayList<>();
        }
        return sSocketInstance;
    }

    public static void setSocketListener(SSSocketListener listener) {
        getInstance().mSocketListener = listener;
    }


    public static void setSubSocketListener(SSSocketListener listener) {
        getInstance().mSubSocketListener = listener;
    }

    public static void addSocketListener(SSSocketListener listener) {
        getInstance().sSocketRegisteredListeners.add(listener);
    }

    public static void removeSocketListener(SSSocketListener listener) {
        getInstance().sSocketRegisteredListeners.remove(listener);
    }

    public SSSocketListener getSocketListener(Context context) {
        if (mSocketListener != null) {
            return mSocketListener;
        }
        if (context.getApplicationContext() instanceof SSSocketListener) {
            return (SSSocketListener) context.getApplicationContext();
        }
        throw new IllegalStateException("Please implement SSSocketListener or use method " + "addGcmListener()");
    }

    public SSSocketListener getSubSocketListener(Context context) {
        if (mSubSocketListener != null) {
            return mSubSocketListener;
        }
        if (context.getApplicationContext() instanceof SSSocketListener) {
            return (SSSocketListener) context.getApplicationContext();
        }
        throw new IllegalStateException("Please implement SSSocketListener or use method " + "addGcmListener()");
    }

    public List<SSSocketListener> getSocketListeners(Context context) {
        if (sSocketRegisteredListeners != null) {
            return sSocketRegisteredListeners;
        }
        throw new IllegalStateException("Please implement SSSocketListener or use method " + "addGcmListener()");
    }
}

