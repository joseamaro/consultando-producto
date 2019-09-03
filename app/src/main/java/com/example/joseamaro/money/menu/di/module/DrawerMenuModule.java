package com.example.joseamaro.money.menu.di.module;

import com.example.joseamaro.money.product.presentation.fragment.ProductFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by joseamaro on 02-09-19.
 */

@Module
public class DrawerMenuModule {
    @Provides
    ProductFragment provideProductFragment(){

        return new ProductFragment();
    }
}
