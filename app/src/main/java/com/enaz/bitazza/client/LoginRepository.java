package com.enaz.bitazza.client;

import retrofit2.Call;

/**
 * Created by eduardo.delito on 6/21/20.
 */
public interface LoginRepository {

    Call<Authenticate> authenticate(String userName, String Password);
}
