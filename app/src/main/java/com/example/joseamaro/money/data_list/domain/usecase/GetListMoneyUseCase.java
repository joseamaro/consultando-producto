package com.example.joseamaro.money.data_list.domain.usecase;

import com.core.domain.usecase.UseCase;
import com.example.joseamaro.money.data_list.data.repository.ListMoneyRepository;
import com.example.joseamaro.money.data_list.domain.model.Money;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by joseamaro on 20-06-19.
 */

public class GetListMoneyUseCase extends UseCase<List<Money>> {

    private final ListMoneyRepository listMoneyRepository;

    @Inject
    public GetListMoneyUseCase(ListMoneyRepository listMoneyRepository) {
        this.listMoneyRepository = listMoneyRepository;
    }

    @Override
    protected Observable<List<Money>> createObservableUseCase() {
        return listMoneyRepository.getMoney();
    }
}
