package com.example.joseamaro.money.data_list.presentation.activity;



import com.core.presentation.activity.BaseFragmentActivity;
import com.example.joseamaro.money.data_list.di.component.DaggerListMoneyActivityComponent;
import com.example.joseamaro.money.data_list.presentation.fragment.ListMoneyFragment;
import com.example.joseamaro.money.databinding.FragmentListMoneyBinding;
import com.example.joseamaro.money.R;


import javax.inject.Inject;

public class ListMoneyActivity extends BaseFragmentActivity<FragmentListMoneyBinding> {

    @Inject
    ListMoneyFragment listMoneyFragment;

    @Override
    protected int getFragmentContainerId() {
        return R.id.fragmentContainer;
    }

    @Override
    protected void initView() {

        setFragment(listMoneyFragment);
    }

    @Override
    protected void injectDependencies() {

        DaggerListMoneyActivityComponent.builder().build().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_list_money;
    }

}
