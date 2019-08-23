package com.example.joseamaro.money.data_list.data.repository;


import com.example.joseamaro.money.data_list.data.remote.ListMoneyApi;
import com.example.joseamaro.money.data_list.domain.model.Money;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by joseamaro on 20-06-19.
 */

public class ListMoneyRepositoryImp implements ListMoneyRepository {

    private final ListMoneyApi api;

    public ListMoneyRepositoryImp(ListMoneyApi api) {
        this.api = api;
    }

    @Override
    public Observable<List<Money>> getMoney() {
        return api.getMoney().map(new Function<String, List<Money>>() {
            @Override
            public List<Money> apply(String indicator) throws Exception {

                ArrayList<Money> list = new ArrayList<>();
                Gson gson = new Gson();
                JsonObject obj = new JsonParser().parse(indicator).getAsJsonObject();
                for(Map.Entry<String,JsonElement> entry:obj.entrySet()){
                    if(entry.getValue() instanceof JsonObject) {
                        Money some = gson.fromJson(entry.getValue().getAsJsonObject(), Money.class);
                        list.add(some);
                    }
                }
                return list;
            }
        });
    }

}
