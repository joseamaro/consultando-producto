package com.example.joseamaro.money.product.domain.usecase;

import com.example.joseamaro.money.product.domain.model.Category;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by joseamaro on 22-08-19.
 */

public class GetCategoryUseCase {

    private List<Category> categoryList;

    @Inject
    public GetCategoryUseCase(){}

    public List<Category> getCategoryList(){

        categoryList = new ArrayList<>();

        Category category = new Category();
        category.sku = "2000371667503P";
        category.nameCategory = "electro";
        categoryList.add(category);


        category = new Category();
        category.sku = "2000351773811P";
        category.nameCategory = "electro";
        categoryList.add(category);


        category = new Category();
        category.sku = "2000369109855P";
        category.nameCategory = "electro";
        categoryList.add(category);

        category = new Category();
        category.sku = "2000366737198P";
        category.nameCategory = "electro";
        categoryList.add(category);

        category = new Category();
        category.sku = "2000372411631P";
        category.nameCategory = "electro";
        categoryList.add(category);

        category = new Category();
        category.sku = "2000359329935P";
        category.nameCategory = "tecno";
        categoryList.add(category);


        category = new Category();
        category.sku = "2000375421729P";
        category.nameCategory = "tecno";
        categoryList.add(category);


        category = new Category();
        category.sku = "2000372107077P";
        category.nameCategory = "tecno";
        categoryList.add(category);


        category = new Category();
        category.sku = "2000371958953P";
        category.nameCategory = "tecno";
        categoryList.add(category);


        category = new Category();
        category.sku = "2000373857964P";
        category.nameCategory = "tecno";
        categoryList.add(category);


        category = new Category();
        category.sku = "2000371827983P";
        category.nameCategory = "decohogar";
        categoryList.add(category);


        category = new Category();
        category.sku = "2000374299572P";
        category.nameCategory = "decohogar";
        categoryList.add(category);


        category = new Category();
        category.sku = "2000374310932P";
        category.nameCategory = "decohogar";
        categoryList.add(category);


        category = new Category();
        category.sku = "2000368425048P";
        category.nameCategory = "decohogar";
        categoryList.add(category);


        category = new Category();
        category.sku = "2000371915604P";
        category.nameCategory = "decohogar";
        categoryList.add(category);


        category = new Category();
        category.sku = "2000369989594P";
        category.nameCategory = "deporte";
        categoryList.add(category);

        category = new Category();
        category.sku = "MPM00002006512";
        category.nameCategory = "deporte";
        categoryList.add(category);

        category = new Category();
        category.sku = "2000335659285P";
        category.nameCategory = "deporte";
        categoryList.add(category);

        category = new Category();
        category.sku = "2000327637482P";
        category.nameCategory = "deporte";
        categoryList.add(category);


        category = new Category();
        category.sku = "MPM00001075806";
        category.nameCategory = "deporte";
        categoryList.add(category);


        category = new Category();
        category.sku = "2000370840266";
        category.nameCategory = "moda";
        categoryList.add(category);


        category = new Category();
        category.sku = "2000371979422";
        category.nameCategory = "moda";
        categoryList.add(category);

        category = new Category();
        category.sku = "2000373199514";
        category.nameCategory = "moda";
        categoryList.add(category);

        category = new Category();
        category.sku = "2000373423879";
        category.nameCategory = "moda";
        categoryList.add(category);

        category = new Category();
        category.sku = "2000372471789";
        category.nameCategory = "moda";
        categoryList.add(category);

        return categoryList;
    }
}
