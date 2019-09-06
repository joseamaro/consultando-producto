package com.example.joseamaro.money.product.presentation.adapter;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.core.presentation.adapter.BaseListAdapter;
import com.core.presentation.adapter.OnItemClickListener;
import com.core.presentation.adapter.holder.BaseViewHolder;
import com.example.joseamaro.money.databinding.ItemDetailsProductBinding;
import com.example.joseamaro.money.product.domain.model.Product;
import com.example.joseamaro.money.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joseamaro on 22-08-19.
 */

public class ProductAdapter extends BaseListAdapter<Product, ProductAdapter.ProductHolder> {

    private OnItemClickListener<Product> onItemClickListener;

    private List<Product> listProduct = new ArrayList<>();


    @Override
    protected RecyclerView.ViewHolder createViewHolder(int viewType, View v) {
        return new ProductAdapter.ProductHolder(v);

    }

    public void setOnItemClickListener(OnItemClickListener<Product> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setListProduct(List<Product> products){
        this.listProduct.addAll(listProduct);
    }

    @Override
    protected int getLayoutIdByType(int viewType) {
        return R.layout.item_details_product;
    }

    class ProductHolder extends BaseViewHolder<Product, ItemDetailsProductBinding> {

        View view;

        public ProductHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            this.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(getAdapterPosition(), getItem(getAdapterPosition()));
                }
            });
        }

        @Override
        public void bind(int position, final Product item) {

            Glide.with(view.getContext())
                    .load("https:" + item.fullImage)
                    .centerCrop()
                    .error(R.drawable.image_product)
                    .placeholder(R.drawable.image_product)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)
                    .into(binder.ivProduct);

            binder.tvNameProduct.setText(item.name);
            if (item.prices.cardPrice == 0) {
                binder.tvPrice.setText(String.valueOf("$" + item.prices.listPrice));
                binder.tvPriceDiscount.setVisibility(View.GONE);
                binder.ivCardRipley.setVisibility(View.GONE);
            } else {
                binder.tvPrice.setText(String.valueOf("$" + item.prices.listPrice));
                binder.tvPrice.setPaintFlags(binder.tvPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                binder.tvPriceDiscount.setVisibility(View.VISIBLE);
                binder.tvPriceDiscount.setText(String.valueOf("$" + item.prices.cardPrice));
                binder.ivCardRipley.setVisibility(View.VISIBLE);
            }

        }

/*
        public void filter(String text) {
            list.clear();
            if (text.isEmpty()) {
                list.addAll(listMoney);
            } else {
                text = text.toLowerCase();
                for (Money money : listMoney) {
                    if (money.codigo.toLowerCase().contains(text)) {
                        list.add(money);
                    }
                }
            }
            notifyDataSetChanged();
        }*/

    }

}
