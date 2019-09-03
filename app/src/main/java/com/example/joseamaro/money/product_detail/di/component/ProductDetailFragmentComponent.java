package com.example.joseamaro.money.product_detail.di.component;

import com.core.di.component.FragmentComponent;
import com.example.joseamaro.money.product_detail.di.module.ProductDetailFragmentModule;
import com.example.joseamaro.money.product_detail.presentation.fragment.ProductDetailFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by joseamaro on 20-06-19.
 */

@Singleton
@Component(modules = {ProductDetailFragmentModule.class})
public interface ProductDetailFragmentComponent extends FragmentComponent<ProductDetailFragment> {
}
