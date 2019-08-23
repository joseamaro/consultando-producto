package com.example.joseamaro.money.product.presentation.contract;

import com.core.presentation.contract.BaseViewPresenter;
import com.core.presentation.contract.IProgressView;
import com.example.joseamaro.money.product.domain.model.Product;

import java.util.List;

/**
 * Created by joseamaro on 19-06-19.
 */

public interface ProductContract {

    interface View extends IProgressView {
        void displayProducts(List<Product> items);
    }

    interface Presenter extends BaseViewPresenter<ProductContract.View> {
    }
}
