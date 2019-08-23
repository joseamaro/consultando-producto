package com.example.joseamaro.money.product.di.module;

import com.core.data.remote.ApiServiceFactory;
import com.example.joseamaro.money.product.data.remote.ProductApi;
import com.example.joseamaro.money.product.data.repository.ProductRepository;
import com.example.joseamaro.money.product.data.repository.ProductRepositoryImp;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by joseamaro on 22-08-19.
 */

@Module
public class ProductRepositoryModule {

    @Provides
    ProductRepository provideRepository(ProductApi api) {
        return new ProductRepositoryImp(api);

    }

    @Provides
    ProductApi provideApiService() {
        OkHttpClient okHttpClient = new OkHttpClient();
        return ApiServiceFactory.build(okHttpClient, ProductApi.class, "https://simple.ripley.cl/");
    }
}
