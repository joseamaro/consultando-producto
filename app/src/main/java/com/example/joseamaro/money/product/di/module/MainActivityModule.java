package com.example.joseamaro.money.product.di.module;


import com.example.joseamaro.money.product.presentation.fragment.ProductFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by joseamaro on 18-06-19.
 */

@Module
public class MainActivityModule {

    @Provides
    ProductFragment provideFragment(){
        return ProductFragment.newInstance();
    }

}
