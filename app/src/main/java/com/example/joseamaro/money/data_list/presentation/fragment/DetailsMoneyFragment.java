package com.example.joseamaro.money.data_list.presentation.fragment;


import android.view.View;

import com.core.presentation.fragment.BaseFragment;
import com.example.joseamaro.money.data_list.domain.model.Money;
import com.google.gson.Gson;
import com.example.joseamaro.money.R;

/**
 * Created by joseamaro on 20-06-19.
 */

public class DetailsMoneyFragment  {

    private Money money;
/*
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_details_money;
    }

    @Override
    protected void initView() {

        String jsonMoney = getArguments().getString("money");
        money = new Gson().fromJson(jsonMoney, Money.class);
        binder.tvName.setText(money.nombre);
        binder.tvCode.setText(money.codigo);
        binder.tvUnid.setText(money.unidad_medida);
        binder.tvDate.setText(money.fecha);
        binder.tvValue.setText(money.valor);

        binder.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });
    }

    @Override
    protected void injectDependencies() {

    }*/
}
