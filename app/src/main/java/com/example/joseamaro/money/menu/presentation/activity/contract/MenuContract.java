package com.example.joseamaro.money.menu.presentation.activity.contract;

import com.core.presentation.contract.IProgressView;

public interface MenuContract {
    interface View extends IProgressView {
        public void lockDrawer();
        public void unlockDrawer();
    }
}
