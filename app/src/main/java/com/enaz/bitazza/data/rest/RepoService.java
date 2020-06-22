package com.enaz.bitazza.data.rest;

import com.enaz.bitazza.client.Authenticate;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by eduardo.delito on 6/17/20.
 */
public interface RepoService {

    @GET("#authenticateuser/{UserName}/{Password}")
    Call<Authenticate> authenticateUser(@Path("UserName") String Username,
                                        @Path("Password") String Password);
}
