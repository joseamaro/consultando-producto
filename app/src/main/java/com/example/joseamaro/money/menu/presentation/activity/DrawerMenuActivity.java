package com.example.joseamaro.money.menu.presentation.activity;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.core.presentation.activity.BaseNavigationDrawerActivity;
import com.core.util.AndroidUtils;
import com.example.joseamaro.money.databinding.ActivityDrawerMenuBinding;
import com.example.joseamaro.money.R;
import com.example.joseamaro.money.menu.di.component.DaggerDrawerMenuComponent;
import com.example.joseamaro.money.menu.presentation.activity.contract.MenuContract;
import com.example.joseamaro.money.product.domain.model.Product;
import com.example.joseamaro.money.product.presentation.contract.ProductContract;
import com.example.joseamaro.money.product.presentation.fragment.ProductFragment;

import java.util.List;

import javax.inject.Inject;

public class DrawerMenuActivity extends BaseNavigationDrawerActivity<ActivityDrawerMenuBinding> implements MenuContract.View {

    @Inject
    ProductFragment productFragment;

    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private boolean iconToggleBack;

    @Override
    protected void initView() {

        setFragment(productFragment);
        drawer = findViewById(R.id.menu_drawer_layout);
        binder.menuContent.ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iconToggleBack) {
                    onBackPressed();
                } else {
                    AndroidUtils.hideKeyboard(DrawerMenuActivity.this);
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });
    }

    @Override
    protected void injectDependencies() {

        DaggerDrawerMenuComponent.builder().build().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_drawer_menu;
    }

    @Override
    protected int getFragmentContainerId() {
        return R.id.fragmentContainer;
    }

    @Override
    public void lockDrawer() {
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    @Override
    public void unlockDrawer() {
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

    @Override
    public void showProgress(boolean show) {

    }

    @Override
    public void showMessage(String message) {

    }
}
