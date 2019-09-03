package com.example.joseamaro.money.product.presentation.activity;




import com.core.presentation.activity.BaseFragmentActivity;
import com.example.joseamaro.money.databinding.ActivityMainBinding;
import com.example.joseamaro.money.product.di.component.DaggerMainActivityComponent;
import com.example.joseamaro.money.product.presentation.fragment.ProductFragment;
import com.example.joseamaro.money.R;


import javax.inject.Inject;

public class MainActivity extends BaseFragmentActivity<ActivityMainBinding> {

    @Inject
    ProductFragment productFragment;

    @Override
    protected int getFragmentContainerId() {
        return R.id.fragmentContainer;
    }

    @Override
    protected void initView() {

        setFragment(productFragment);
    }

    @Override
    protected void injectDependencies() {
        DaggerMainActivityComponent.builder().build().inject(this);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

}
