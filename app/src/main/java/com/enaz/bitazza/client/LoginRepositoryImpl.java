package com.enaz.bitazza.client;

import javax.inject.Inject;

import retrofit2.Call;

/**
 * Created by eduardo.delito on 6/21/20.
 */
public class LoginRepositoryImpl implements LoginRepository {

    private final BitazzaApiClient bitazzaApiClient;

    @Inject
    public LoginRepositoryImpl(BitazzaApiClient bitazzaApiClient) {
        this.bitazzaApiClient = bitazzaApiClient;
    }

    @Override
    public Call<Authenticate> authenticate(String userName, String password) {
        return bitazzaApiClient.authenticateService().authenticateUser(userName, password);
    }
}
