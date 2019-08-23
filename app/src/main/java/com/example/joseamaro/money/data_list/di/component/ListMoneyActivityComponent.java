package com.example.joseamaro.money.data_list.di.component;

import com.core.di.component.ActivityComponent;
import com.example.joseamaro.money.data_list.di.module.ListMoneyActivityModule;
import com.example.joseamaro.money.data_list.presentation.activity.ListMoneyActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by joseamaro on 19-06-19.
 */

@Singleton
@Component(modules = {ListMoneyActivityModule.class})
public interface ListMoneyActivityComponent extends ActivityComponent<ListMoneyActivity> {
}
