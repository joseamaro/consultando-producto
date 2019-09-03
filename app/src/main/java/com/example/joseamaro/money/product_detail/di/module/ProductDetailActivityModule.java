package com.example.joseamaro.money.product_detail.di.module;


import com.example.joseamaro.money.product_detail.presentation.fragment.ProductDetailFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by joseamaro on 19-06-19.
 */

@Module
public class ProductDetailActivityModule {

    @Provides
    ProductDetailFragment provideFragment(){
        return ProductDetailFragment.newInstance();
    }
}
