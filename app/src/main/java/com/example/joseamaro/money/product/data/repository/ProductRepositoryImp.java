package com.example.joseamaro.money.product.data.repository;

import com.example.joseamaro.money.product.data.remote.ProductApi;
import com.example.joseamaro.money.product.domain.model.Product;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * Created by joseamaro on 21-08-19.
 */

public class ProductRepositoryImp implements ProductRepository {

    private final ProductApi productApi;

    public ProductRepositoryImp(ProductApi productApi) {
        this.productApi = productApi;
    }

    @Override
    public Observable<Product> getProduct(String sku) {
        return productApi.getProduct(sku).map(new Function<Product, Product>() {
            @Override
            public Product apply(Product product) throws Exception {
                return product;
            }
        });
    }
}
