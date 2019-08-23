package com.example.joseamaro.money.product.di.component;

import com.core.di.component.FragmentComponent;
import com.example.joseamaro.money.product.di.module.ProductFragmentModule;
import com.example.joseamaro.money.product.di.module.ProductRepositoryModule;
import com.example.joseamaro.money.product.presentation.fragment.ProductFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by joseamaro on 19-06-19.
 */

@Singleton
@Component(modules = {ProductFragmentModule.class, ProductRepositoryModule.class})
public interface ProductFragmentComponent extends FragmentComponent<ProductFragment> {
}
