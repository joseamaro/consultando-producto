package com.example.joseamaro.money.data_list.di.module;

import com.core.data.remote.ApiServiceFactory;
import com.example.joseamaro.money.data_list.data.remote.ListMoneyApi;
import com.example.joseamaro.money.data_list.data.repository.ListMoneyRepository;
import com.example.joseamaro.money.data_list.data.repository.ListMoneyRepositoryImp;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by joseamaro on 20-06-19.
 */

@Module
public class ListMoneyRepositoryModule {
    @Provides
    ListMoneyRepository provideRepository(ListMoneyApi api) {
        return new ListMoneyRepositoryImp(api);

    }

    @Provides
    ListMoneyApi provideApiService() {
        OkHttpClient okHttpClient = new OkHttpClient();
        return ApiServiceFactory.build(okHttpClient, ListMoneyApi.class, "https://www.mindicador.cl/");
    }
}
