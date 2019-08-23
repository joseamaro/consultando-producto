package com.example.joseamaro.money.product.data.repository;

import com.example.joseamaro.money.product.domain.model.Product;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by joseamaro on 21-08-19.
 */

public interface ProductRepository {
    Observable<Product> getProduct(String sku);
}
