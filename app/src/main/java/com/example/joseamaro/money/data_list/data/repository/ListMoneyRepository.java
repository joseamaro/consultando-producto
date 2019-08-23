package com.example.joseamaro.money.data_list.data.repository;

import com.example.joseamaro.money.data_list.domain.model.Money;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by joseamaro on 20-06-19.
 */

public interface ListMoneyRepository {
    Observable<List<Money>> getMoney();
}
