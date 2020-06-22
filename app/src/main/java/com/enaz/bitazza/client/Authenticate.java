package com.enaz.bitazza.client;

/**
 * Created by eduardo.delito on 6/21/20.
 */
public class Authenticate {
    public boolean authenticated;
    public User user;
    public boolean locked;
    public boolean requires2FA;
    public String twoFAType;
    public String twoFAToken;
    public String errormsg;

    public Authenticate(boolean authenticated, User user, boolean locked,
                        boolean requires2FA, String twoFAType, String twoFAToken, String errormsg) {
        this.authenticated = authenticated;
        this.user = user;
        this.locked = locked;
        this.requires2FA = requires2FA;
        this.twoFAType = twoFAType;
        this.twoFAToken = twoFAToken;
        this.errormsg = errormsg;

    }
}
