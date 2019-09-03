package com.example.joseamaro.money.product.di.module;

import android.content.Context;
import com.example.joseamaro.money.product.domain.model.App;
import com.example.joseamaro.money.product.domain.usecase.GetCategoryUseCase;
import com.example.joseamaro.money.product.domain.usecase.GetProductUseCase;
import com.example.joseamaro.money.product.domain.usecase.GetSkuUseCase;
import com.example.joseamaro.money.product.presentation.adapter.ProductAdapter;
import com.example.joseamaro.money.product.presentation.contract.ProductContract;
import com.example.joseamaro.money.product.presentation.presenter.ProductPresenter;
import com.example.joseamaro.money.product_detail.presentation.fragment.ProductDetailFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by joseamaro on 19-06-19.
 */

@Module
public class ProductFragmentModule {

    @Provides Context provideContext() {
        return App.getInstance();
    }

    @Provides
    ProductAdapter provideAdapter() {
        return new ProductAdapter();
    }

    @Provides
    ProductDetailFragment provideProductDetailFragment(){

        return new ProductDetailFragment();
    }

    @Provides
    ProductContract.Presenter providePresenter(GetSkuUseCase getSkuUseCase, GetCategoryUseCase getCategoryUseCase, GetProductUseCase getProductUseCase) {
        return new ProductPresenter(getSkuUseCase, getCategoryUseCase, getProductUseCase);
    }
}
