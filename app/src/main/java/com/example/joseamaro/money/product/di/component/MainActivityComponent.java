package com.example.joseamaro.money.product.di.component;

import com.core.di.component.ActivityComponent;
import com.example.joseamaro.money.product.di.module.MainActivityModule;
import com.example.joseamaro.money.product.presentation.activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by joseamaro on 18-06-19.
 */

@Singleton
@Component(modules = {MainActivityModule.class})
public interface MainActivityComponent extends ActivityComponent<MainActivity>{}
