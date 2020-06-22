package com.enaz.bitazza.di.module;

import com.enaz.bitazza.client.BitazzaApiClient;
import com.enaz.bitazza.client.LoginRepository;
import com.enaz.bitazza.client.LoginRepositoryImpl;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module(includes = ViewModelModule.class)
public class ApplicationModule {

    @Provides
    @Singleton
    static OkHttpClient provideHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(0, TimeUnit.NANOSECONDS)
                .writeTimeout(0, TimeUnit.NANOSECONDS)
                .readTimeout(0, TimeUnit.NANOSECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }

    @Provides
    @Singleton
    static OkHttpClient.Builder provideHttpClientBuilder() {
        return new OkHttpClient.Builder();
    }

    @Provides
    @Singleton
    static BitazzaApiClient provideBitazzaApiClient(OkHttpClient.Builder okHttpClient) {
        return new BitazzaApiClient(okHttpClient);
    }

    @Singleton
    @Provides
    static LoginRepository provideLoginRepository(BitazzaApiClient bitazzaApiClient) {
        return new LoginRepositoryImpl(bitazzaApiClient);
    }
}
