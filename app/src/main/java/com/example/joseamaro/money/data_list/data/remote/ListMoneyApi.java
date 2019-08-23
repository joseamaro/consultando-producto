package com.example.joseamaro.money.data_list.data.remote;




import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by joseamaro on 20-06-19.
 */

public interface ListMoneyApi {

    @GET("api")
    Observable<String> getMoney();
}
