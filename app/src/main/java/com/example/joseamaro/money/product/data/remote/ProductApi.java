package com.example.joseamaro.money.product.data.remote;


import com.example.joseamaro.money.product.domain.model.Product;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by joseamaro on 21-08-19.
 */

public interface ProductApi {

    @GET("api/v2/products/{sku}")
    Observable<Product> getProduct(@Path("sku") String sku);
}
