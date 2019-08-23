package com.example.joseamaro.money.product.presentation.fragment;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.core.presentation.adapter.OnItemClickListener;
import com.core.presentation.fragment.BaseStackFragment;
import com.example.joseamaro.money.R;
import com.example.joseamaro.money.databinding.FragmentProductBinding;
import com.example.joseamaro.money.product.di.component.DaggerProductFragmentComponent;
import com.example.joseamaro.money.product.domain.model.Product;
import com.example.joseamaro.money.product.presentation.adapter.ProductAdapter;
import com.example.joseamaro.money.product.presentation.contract.ProductContract;

import java.util.List;

import javax.inject.Inject;


/**
 * Created by joseamaro on 18-06-19.
 */

public class ProductFragment extends BaseStackFragment<FragmentProductBinding> implements ProductContract.View, OnItemClickListener<Product> {

    @Inject
    ProductContract.Presenter presenter;

    @Inject
    ProductAdapter adapter;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_product;
    }

    @Override
    protected void initView() {

        presenter.initialize(this);
        binder.recyclerView.setAdapter(adapter);
        GridLayoutManager llm = new GridLayoutManager(getContext(),2);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        binder.recyclerView.setLayoutManager(llm);
    }

    @Override
    protected void injectDependencies() {

        DaggerProductFragmentComponent.builder().build().inject(this);
    }

    public static ProductFragment newInstance() {
        ProductFragment instance = new ProductFragment();
        return instance;
    }

    @Override
    public void showProgress(boolean show) {

        binder.progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showMessage(String message) {

        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();

    }

    @Override
    protected int getNavigationContainer() {
        return 0;
    }


    @Override
    public void displayProducts(List<Product> items) {
        adapter.setList(items);
        adapter.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(int adapterPosition, Product item) {

    }
}
