package com.example.joseamaro.money.data_list.di.component;

import com.core.di.component.FragmentComponent;
import com.example.joseamaro.money.data_list.di.module.ListMoneyFragmentModule;
import com.example.joseamaro.money.data_list.di.module.ListMoneyRepositoryModule;
import com.example.joseamaro.money.data_list.presentation.fragment.ListMoneyFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by joseamaro on 20-06-19.
 */

@Singleton
@Component(modules = {ListMoneyFragmentModule.class, ListMoneyRepositoryModule.class})
public interface ListMoneyFragmentComponent extends FragmentComponent<ListMoneyFragment> {
}
