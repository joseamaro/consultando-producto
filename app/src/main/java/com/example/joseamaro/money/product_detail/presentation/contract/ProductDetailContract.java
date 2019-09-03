package com.example.joseamaro.money.product_detail.presentation.contract;

import com.core.presentation.contract.BaseViewPresenter;
import com.core.presentation.contract.IProgressView;

import java.util.List;

/**
 * Created by joseamaro on 20-06-19.
 */

public interface ProductDetailContract {

    interface View extends IProgressView {

    }

    interface Presenter extends BaseViewPresenter<View> {

    }
}
