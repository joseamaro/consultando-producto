package com.example.joseamaro.money.product.presentation.fragment;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.core.presentation.adapter.OnItemClickListener;
import com.core.presentation.fragment.BaseStackFragment;
import com.example.joseamaro.money.R;
import com.example.joseamaro.money.databinding.FragmentProductBinding;
import com.example.joseamaro.money.menu.presentation.activity.DrawerMenuActivity;
import com.example.joseamaro.money.product.di.component.DaggerProductFragmentComponent;
import com.example.joseamaro.money.product.domain.model.Product;
import com.example.joseamaro.money.product.presentation.adapter.ProductAdapter;
import com.example.joseamaro.money.product.presentation.contract.ProductContract;
import com.example.joseamaro.money.product_detail.presentation.fragment.ProductDetailFragment;
import com.google.gson.Gson;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;


/**
 * Created by joseamaro on 18-06-19.
 */

public class ProductFragment extends BaseStackFragment<FragmentProductBinding> implements ProductContract.View, OnItemClickListener<Product> {

    @Inject
    ProductContract.Presenter presenter;

    @Inject
    ProductAdapter adapter;

    @Inject
    ProductDetailFragment productDetailFragment;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_product;
    }

    @Override
    protected int getNavigationContainer() {
        return R.id.fragmentContainer;
    }


    @Override
    protected void initView() {

        presenter.initialize(this);
        binder.recyclerView.setAdapter(adapter);
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
    public void displayProducts(List<Product> items) {
        adapter.setList(items);
        adapter.setOnItemClickListener(this);
        GridLayoutManager llm = new GridLayoutManager(getContext(), 2);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        binder.recyclerView.setLayoutManager(llm);

    }

    @Override
    public void onItemClick(int adapterPosition, Product item) {
        Bundle b = new Bundle();
        b.putString("product", new Gson().toJson(item));
        productDetailFragment.setArguments(b);
        addFragmentToStack(productDetailFragment);
    }



}
