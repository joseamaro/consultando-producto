package com.example.joseamaro.money.product_detail.presentation.fragment;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.core.presentation.fragment.BaseFragment;
import com.example.joseamaro.money.menu.presentation.activity.DrawerMenuActivity;
import com.example.joseamaro.money.product.domain.model.Attributes;
import com.example.joseamaro.money.product.domain.model.Product;
import com.example.joseamaro.money.product.presentation.activity.MainActivity;
import com.example.joseamaro.money.product_detail.di.component.DaggerProductDetailFragmentComponent;
import com.example.joseamaro.money.product_detail.presentation.Utils.CirclePagerIndicatorDecoration;
import com.example.joseamaro.money.product_detail.presentation.adapter.ProductDetailAdapter;
import com.example.joseamaro.money.product_detail.presentation.contract.ProductDetailContract;
import com.example.joseamaro.money.databinding.FragmentDetailsProductsBinding;
import com.example.joseamaro.money.R;
import com.google.gson.Gson;

import java.util.Objects;

import javax.inject.Inject;


/**
 * Created by joseamaro on 18-06-19.
 */

public class ProductDetailFragment extends BaseFragment<FragmentDetailsProductsBinding> implements ProductDetailContract.View {

    @Inject
    ProductDetailContract.Presenter presenter;

    @Inject
    ProductDetailAdapter adapter;

    private Product product;
    private int posImage = -1;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_details_products;
    }

    @Override
    protected void initView() {

        String jsonProduct = getArguments().getString("product");
        product = new Gson().fromJson(jsonProduct, Product.class);
        binder.rvImage.setAdapter(adapter);
        binder.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });
        displayCoupons();
        setAttribute();

    }

    @Override
    protected void injectDependencies() {

        DaggerProductDetailFragmentComponent.builder().build().inject(this);

    }

    public static ProductDetailFragment newInstance() {
        ProductDetailFragment instance = new ProductDetailFragment();
        return instance;
    }

    @Override
    public void showProgress(boolean show) {

    }

    @Override
    public void showMessage(String message) {

    }

    public void setAttribute() {
        binder.tvMarkTo.setText(product.name);
        binder.rlMark.setBackgroundColor(Color.parseColor("#EFEFEF"));
        binder.rlGender.setBackgroundColor(Color.parseColor("#EFEFEF"));

        if (product.prices.cardPrice == 0) {
            binder.tvPrice.setText(String.valueOf("$" + product.prices.listPrice));
            binder.tvPriceDiscount.setVisibility(View.GONE);
            binder.ivCardRipley.setVisibility(View.GONE);
        } else {
            binder.tvPrice.setText(String.valueOf("$" + product.prices.listPrice));
            binder.tvPrice.setPaintFlags(binder.tvPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            binder.tvPriceDiscount.setVisibility(View.VISIBLE);
            binder.tvPriceDiscount.setText(String.valueOf("$" + product.prices.cardPrice));
            binder.ivCardRipley.setVisibility(View.VISIBLE);
        }
        for (Attributes attributes : product.attributes) {
            if (attributes.name.equals("Marca")) {
                binder.tvMark.setText(attributes.value);
            }
            if (attributes.name.equals("Tipo de Prenda")) {
                binder.tvTypeOfGarment.setText(attributes.value);
            }
            if (attributes.name.equals("Género")) {
                binder.tvGender.setText(attributes.value);
            }
            if (attributes.name.equals("Material")) {
                binder.tvMaterial.setText(attributes.value);
            }
        }
    }


    public void displayCoupons() {

        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        adapter.setList(product.images);
        binder.rvImage.addItemDecoration(new CirclePagerIndicatorDecoration());
        binder.rvImage.setLayoutManager(mLayoutManager);
        final PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(binder.rvImage);
        binder.rvImage.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    View centerView = snapHelper.findSnapView(mLayoutManager);
                    posImage = mLayoutManager.getPosition(centerView);
                }
            }
        });

        posImage = 0;
    }

    @Override
    public void onResume() {
        super.onResume();
        Objects.requireNonNull(((AppCompatActivity) Objects.requireNonNull(getActivity())).getSupportActionBar()).hide();
    }

    @Override
    public void onStop() {
        super.onStop();
        Objects.requireNonNull(((AppCompatActivity) Objects.requireNonNull(getActivity())).getSupportActionBar()).show();
    }

}
