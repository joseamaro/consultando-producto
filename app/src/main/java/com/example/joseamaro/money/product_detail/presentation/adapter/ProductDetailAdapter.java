package com.example.joseamaro.money.product_detail.presentation.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.core.presentation.adapter.BaseListAdapter;
import com.core.presentation.adapter.holder.BaseViewHolder;
import com.example.joseamaro.money.databinding.ItemImageBinding;
import com.example.joseamaro.money.R;

/**
 * Created by joseamaro on 28-08-19.
 */

public class ProductDetailAdapter extends BaseListAdapter<String, ProductDetailAdapter.ProductDetailHolder> {

    @Override
    protected RecyclerView.ViewHolder createViewHolder(int viewType, View v) {
        return new ProductDetailAdapter.ProductDetailHolder(v);

    }


    @Override
    protected int getLayoutIdByType(int viewType) {
        return R.layout.item_image;
    }

    class ProductDetailHolder extends BaseViewHolder<String, ItemImageBinding> {

        View view;

        public ProductDetailHolder(View itemView) {
            super(itemView);
            this.view = itemView;
        }

        @Override
        public void bind(int position, final String items) {

            Glide.with(view.getContext())
                    .load("https:" + items )
                    .centerCrop()
                    .error(R.drawable.image_product)
                    .placeholder(R.drawable.image_product)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)
                    .into(binder.ivImageProduct);

        }
    }

}
