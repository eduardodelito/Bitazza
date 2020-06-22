package com.enaz.bitazza.socket;

/**
 * Created by eduardo.delito on 6/22/20.
 */
public class SSocketModelSub {
    private int user_id;
    private boolean online;

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public SSocketModelSub(){
        //Do nothing
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}

