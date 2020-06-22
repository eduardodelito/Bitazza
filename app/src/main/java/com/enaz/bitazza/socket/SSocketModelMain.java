package com.enaz.bitazza.socket;

/**
 * Created by eduardo.delito on 6/22/20.
 */
public class SSocketModelMain {
    private String identifier;
    private SSocketModelSub message;

    public SSocketModelMain(){
        //Do nothing
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public SSocketModelSub getMessage() {
        return message;
    }

    public void setMessage(SSocketModelSub message) {
        this.message = message;
    }
}

