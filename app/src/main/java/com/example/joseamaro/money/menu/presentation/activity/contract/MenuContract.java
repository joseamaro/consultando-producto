package com.example.joseamaro.money.menu.presentation.activity.contract;

import com.core.presentation.contract.IProgressView;

public interface MenuContract {
    interface View extends IProgressView {
        void lockDrawer();
        void unlockDrawer();
    }
}
