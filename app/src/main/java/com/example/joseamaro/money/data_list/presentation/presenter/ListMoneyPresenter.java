package com.example.joseamaro.money.data_list.presentation.presenter;

import com.core.domain.usecase.UseCaseObserver;
import com.example.joseamaro.money.data_list.domain.model.Money;
import com.example.joseamaro.money.data_list.domain.usecase.GetListMoneyUseCase;
import com.example.joseamaro.money.data_list.presentation.contract.ListMoneyContract;
import com.example.joseamaro.money.product.domain.model.UserPreferences;

import java.util.List;

/**
 * Created by joseamaro on 20-06-19.
 */

public class ListMoneyPresenter implements ListMoneyContract.Presenter{

    private UserPreferences preferences;
    private final GetListMoneyUseCase getListMoneyUseCase;

    private ListMoneyContract.View view;

    public ListMoneyPresenter(UserPreferences preferences, GetListMoneyUseCase getListMoneyUseCase) {
        this.preferences = preferences;
        this.getListMoneyUseCase = getListMoneyUseCase;
    }

    @Override
    public void initialize(ListMoneyContract.View view) {
        this.view =view;
        sendNameUser();
        getIndicator();

    }

    public void sendNameUser(){
        view.getNameUser(preferences.getEmail());
    }

    public void getIndicator(){
        getListMoneyUseCase.execute(new UseCaseObserver<List<Money>>() {
            @Override
            public void onNext(List<Money> value) {
                super.onNext(value);
                view.displayIndicator(value);
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }
        });
    }

    @Override
    public void logout() {
        preferences.saveLogin(false);
        view.goToLogin();
    }
}
