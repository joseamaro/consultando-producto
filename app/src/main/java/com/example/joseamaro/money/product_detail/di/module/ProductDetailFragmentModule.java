package com.example.joseamaro.money.product_detail.di.module;

import android.content.Context;

import com.example.joseamaro.money.product_detail.presentation.adapter.ProductDetailAdapter;
import com.example.joseamaro.money.product_detail.presentation.contract.ProductDetailContract;
import com.example.joseamaro.money.product_detail.presentation.presenter.ProductDetailPresenter;
import com.example.joseamaro.money.product.domain.model.App;

import dagger.Module;
import dagger.Provides;

/**
 * Created by joseamaro on 20-06-19.
 */

@Module
public class ProductDetailFragmentModule {

    @Provides
    Context provideContext() {
        return App.getInstance();
    }

    @Provides
    ProductDetailAdapter provideAdapter() {
        return new ProductDetailAdapter();
    }

    @Provides
    ProductDetailContract.Presenter providePresenter() {
        return new ProductDetailPresenter();
    }
}
