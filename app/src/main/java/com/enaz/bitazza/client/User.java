package com.enaz.bitazza.client;

public class User {
    public final int userId;
    public final String userName;
    public final String email;
    public final boolean emailVerified;
    public final int accountId;
    public final int omsId;
    public final boolean use2FA;

    public User(int userId, String userName, String email, boolean emailVerified,
                int accountId, int omsId, boolean use2FA) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.emailVerified = emailVerified;
        this.accountId = accountId;
        this.omsId = omsId;
        this.use2FA = use2FA;
    }
}
