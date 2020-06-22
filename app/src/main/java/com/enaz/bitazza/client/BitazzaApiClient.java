package com.enaz.bitazza.client;

import androidx.annotation.Nullable;

import com.enaz.bitazza.data.rest.RepoService;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Authenticator;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by eduardo.delito on 6/21/20.
 */
public class BitazzaApiClient {
    private static final String BASE_URL = "https://api-doc.bitazza.com/";
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final String HEADER_ACCEPT = "Accept";
    private static final String HEADER_VALUE_APP_JSON = "application/json";
    private Retrofit retrofit;

    public BitazzaApiClient(OkHttpClient.Builder okHttp) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttp.addInterceptor(logging);
//        okHttp.authenticator(this);
        okHttp.connectTimeout(60, TimeUnit.SECONDS);
        okHttp.readTimeout(60, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(okHttp.build())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                        .setLenient()
                        .create()))
                .baseUrl(BASE_URL)
                .build();
    }

//    /**
//     *  method to intercept request.
//     *  @param chain interceptor.
//     */
//    @Override
//    public Response intercept(Chain chain) throws IOException {
//        Request request = chain.request();
//        request = request.newBuilder()
//                .addHeader(HEADER_CONTENT_TYPE, HEADER_VALUE_APP_JSON)
//                .addHeader(HEADER_ACCEPT, HEADER_VALUE_APP_JSON)
//                .build();
//        return chain.proceed(request);
//    }
//
//    /**
//     * Request authenticator
//     * @param route
//     * @param response
//     */
//    @Override
//    public Request authenticate(@Nullable Route route, Response response) throws IOException {
//        return response.request().newBuilder().build();
//    }

    public RepoService authenticateService() {
        return retrofit.create(RepoService.class);
    }
}
