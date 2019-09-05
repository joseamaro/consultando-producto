package com.example.joseamaro.money.product.presentation.presenter;


import android.content.Context;
import android.widget.Toast;

import com.core.domain.usecase.UseCaseObserver;
import com.example.joseamaro.money.product.domain.model.Product;
import com.example.joseamaro.money.product.domain.usecase.GetCategoryUseCase;
import com.example.joseamaro.money.product.domain.usecase.GetProductUseCase;
import com.example.joseamaro.money.product.domain.usecase.GetSkuUseCase;
import com.example.joseamaro.money.product.presentation.contract.ProductContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joseamaro on 19-06-19.
 */

public class ProductPresenter implements ProductContract.Presenter {

    private final GetSkuUseCase getSkuUseCase;
    private final GetCategoryUseCase getCategoryUseCase;
    private final GetProductUseCase getProductUseCase;

    private List<String> sku;
    private ProductContract.View view;

    public ProductPresenter(GetSkuUseCase getSkuUseCase, GetCategoryUseCase getCategoryUseCase, GetProductUseCase getProductUseCase) {

        this.getSkuUseCase = getSkuUseCase;
        this.getCategoryUseCase = getCategoryUseCase;
        this.getProductUseCase = getProductUseCase;
    }

    @Override
    public void initialize(ProductContract.View view) {
        this.view = view;
        sku = getSkuUseCase.getSku();
        insertProduct();
    }


    public void insertProduct() {

        final List<Product> products = new ArrayList<>();

        for (String productSku : sku) {
            getProductUseCase.setData(productSku).execute(new UseCaseObserver<Product>() {
                @Override
                public void onNext(Product value) {
                    super.onNext(value);
                    products.add(value);
                    if (products.size() == 25) {
                        view.displayProducts(products);
                        view.showProgress(false);
                    }
                }

                @Override
                public void onError(Throwable e) {
                    super.onError(e);
                    insertProduct();
                }
            });
        }

    }
}


