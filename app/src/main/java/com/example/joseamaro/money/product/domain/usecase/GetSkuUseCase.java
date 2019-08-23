package com.example.joseamaro.money.product.domain.usecase;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by joseamaro on 21-08-19.
 */

public class GetSkuUseCase {

    private List<String> skuList;

    @Inject
    public GetSkuUseCase (){}

    public List<String>  getSku(){

        skuList = new ArrayList<>();

        skuList.add("2000371667503P");
        skuList.add("2000351773811P");
        skuList.add("2000369109855P");
        skuList.add("2000366737198P");
        skuList.add("2000372411631P");
        skuList.add("2000359329935P");
        skuList.add("2000375421729P");
        skuList.add("2000372107077P");
        skuList.add("2000371958953P");
        skuList.add("2000373857964P");
        skuList.add("2000371827983P");
        skuList.add("2000374299572P");
        skuList.add("2000374310932P");
        skuList.add("2000368425048P");
        skuList.add("2000371915604P");
        skuList.add("2000369989594P");
        skuList.add("MPM00002006512");
        skuList.add("2000335659285P");
        skuList.add("2000327637482P");
        skuList.add("MPM00001075806");
        skuList.add("2000370840266");
        skuList.add("2000371979422");
        skuList.add("2000373199514");
        skuList.add("2000373423879");
        skuList.add("2000372471789");

        return skuList;
    }

}
