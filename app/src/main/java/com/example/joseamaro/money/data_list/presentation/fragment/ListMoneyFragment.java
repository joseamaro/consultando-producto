package com.example.joseamaro.money.data_list.presentation.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import com.core.presentation.adapter.OnItemClickListener;
import com.core.presentation.fragment.BaseStackFragment;
import com.example.joseamaro.money.data_list.di.component.DaggerListMoneyFragmentComponent;
import com.example.joseamaro.money.data_list.domain.model.Money;
import com.example.joseamaro.money.data_list.presentation.adapter.ListMoneyAdapter;
import com.example.joseamaro.money.data_list.presentation.contract.ListMoneyContract;
import com.example.joseamaro.money.databinding.FragmentListMoneyBinding;
import com.example.joseamaro.money.R;
import com.example.joseamaro.money.product.presentation.activity.MainActivity;
import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;


/**
 * Created by joseamaro on 18-06-19.
 */

public class ListMoneyFragment extends BaseStackFragment<FragmentListMoneyBinding> implements ListMoneyContract.View, OnItemClickListener<Money> {

    @Inject
    ListMoneyAdapter listMoneyAdapter;

    @Inject
    DetailsMoneyFragment detailsMoneyFragment;

    @Inject
    ListMoneyContract.Presenter presenter;

    @Override
    protected int getNavigationContainer() {
        return R.id.fragmentContainer;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_list_money;
    }

    @Override
    protected void initView() {

        presenter.initialize(this);
        binder.recyclerView.setAdapter(listMoneyAdapter);
        binder.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.logout();
            }
        });

    }

    @Override
    protected void injectDependencies() {

        DaggerListMoneyFragmentComponent.builder().build().inject(this);

    }

    public static ListMoneyFragment newInstance() {
        ListMoneyFragment instance = new ListMoneyFragment();
        return instance;
    }

    @Override
    public void showProgress(boolean show) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void getNameUser(String user) {
        binder.tvUserName.setText(user);
    }

    @Override
    public void displayIndicator(final List<Money> items) {
        listMoneyAdapter.setList(items);
        listMoneyAdapter.setListMoney(items);
        listMoneyAdapter.setOnItemClickListener(this);
        binder.searchFilter.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                listMoneyAdapter.filter(newText);
                return true;
            }
        });
    }

    @Override
    public void goToLogin() {
        startActivity(MainActivity.class);
        finishActivity();
    }

    @Override
    public void onItemClick(int adapterPosition, Money item) {
      /*  Bundle b = new Bundle();
        b.putString("money", new Gson().toJson(item));
        detailsMoneyFragment.setArguments(b);
        addFragmentToStack(detailsMoneyFragment);*/
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
