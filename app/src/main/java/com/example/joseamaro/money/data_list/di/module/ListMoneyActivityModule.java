package com.example.joseamaro.money.data_list.di.module;


import com.example.joseamaro.money.data_list.presentation.fragment.ListMoneyFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by joseamaro on 19-06-19.
 */

@Module
public class ListMoneyActivityModule {

    @Provides
    ListMoneyFragment provideFragment(){
        return ListMoneyFragment.newInstance();
    }
}
