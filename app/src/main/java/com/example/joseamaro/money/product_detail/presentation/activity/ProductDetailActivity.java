package com.example.joseamaro.money.product_detail.presentation.activity;


import com.core.presentation.activity.BaseFragmentActivity;
import com.example.joseamaro.money.databinding.ActivityProductDetailBinding;
import com.example.joseamaro.money.product_detail.di.component.DaggerProductDetailActivityComponent;
import com.example.joseamaro.money.product_detail.presentation.fragment.ProductDetailFragment;
import com.example.joseamaro.money.R;


import javax.inject.Inject;

public class ProductDetailActivity extends BaseFragmentActivity<ActivityProductDetailBinding> {

    @Inject
    ProductDetailFragment productDetailFragment;

    @Override
    protected int getFragmentContainerId() {
        return R.id.fragmentContainer;
    }

    @Override
    protected void initView() {

        setFragment(productDetailFragment);
    }

    @Override
    protected void injectDependencies() {

        DaggerProductDetailActivityComponent.builder().build().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_product_detail;
    }

}
