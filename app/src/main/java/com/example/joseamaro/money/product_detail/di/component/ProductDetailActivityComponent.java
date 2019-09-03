package com.example.joseamaro.money.product_detail.di.component;

import com.core.di.component.ActivityComponent;
import com.example.joseamaro.money.product_detail.di.module.ProductDetailActivityModule;
import com.example.joseamaro.money.product_detail.presentation.activity.ProductDetailActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by joseamaro on 19-06-19.
 */

@Singleton
@Component(modules = {ProductDetailActivityModule.class})
public interface ProductDetailActivityComponent extends ActivityComponent<ProductDetailActivity> {
}
