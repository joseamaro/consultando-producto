package com.example.joseamaro.money.data_list.di.module;

import android.content.Context;

import com.example.joseamaro.money.data_list.domain.usecase.GetListMoneyUseCase;
import com.example.joseamaro.money.data_list.presentation.adapter.ListMoneyAdapter;
import com.example.joseamaro.money.data_list.presentation.contract.ListMoneyContract;
import com.example.joseamaro.money.data_list.presentation.fragment.DetailsMoneyFragment;
import com.example.joseamaro.money.data_list.presentation.presenter.ListMoneyPresenter;
import com.example.joseamaro.money.product.domain.model.App;
import com.example.joseamaro.money.product.domain.model.UserPreferences;

import dagger.Module;
import dagger.Provides;

/**
 * Created by joseamaro on 20-06-19.
 */

@Module
public class ListMoneyFragmentModule {

    @Provides
    Context provideContext() {
        return App.getInstance();
    }

    @Provides
    ListMoneyAdapter provideAdapter() {
        return new ListMoneyAdapter();
    }

    @Provides
    DetailsMoneyFragment provideShoppingHistoryFragment(){
        return new DetailsMoneyFragment();
    }

    @Provides
    ListMoneyContract.Presenter providePresenter(UserPreferences preferences, GetListMoneyUseCase getListMoneyUseCase) {
        return new ListMoneyPresenter(preferences, getListMoneyUseCase);
    }
}
