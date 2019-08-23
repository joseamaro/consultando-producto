package com.example.joseamaro.money.product.domain.usecase;

import com.core.domain.usecase.UseCase;
import com.example.joseamaro.money.product.data.repository.ProductRepository;
import com.example.joseamaro.money.product.domain.model.Product;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by joseamaro on 22-08-19.
 */

public class GetProductUseCase extends UseCase<Product> {

    private String sku;
    private final ProductRepository productRepository;

    @Inject
    public GetProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public GetProductUseCase setData(String sku) {
        this.sku = sku;
        return this;
    }

    @Override
    protected Observable<Product> createObservableUseCase() {
        return productRepository.getProduct(sku);
    }
}
