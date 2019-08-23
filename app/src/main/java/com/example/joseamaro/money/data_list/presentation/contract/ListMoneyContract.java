package com.example.joseamaro.money.data_list.presentation.contract;

import com.core.presentation.contract.BaseViewPresenter;
import com.core.presentation.contract.IProgressView;
import com.example.joseamaro.money.data_list.domain.model.Money;

import java.util.List;

/**
 * Created by joseamaro on 20-06-19.
 */

public interface ListMoneyContract {

    interface View extends IProgressView {
        void getNameUser(String user);
        void displayIndicator(List<Money> items);
        void goToLogin();
    }

    interface Presenter extends BaseViewPresenter<View> {

        void logout();
    }
}
