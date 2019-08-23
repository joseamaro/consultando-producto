package com.example.joseamaro.money.data_list.presentation.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.core.presentation.adapter.BaseListAdapter;
import com.core.presentation.adapter.OnItemClickListener;
import com.core.presentation.adapter.holder.BaseViewHolder;
import com.example.joseamaro.money.data_list.domain.model.Money;
import com.example.joseamaro.money.R;
import com.example.joseamaro.money.databinding.ItemIndicatorBinding;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by joseamaro on 20-06-19.
 */

public class ListMoneyAdapter extends BaseListAdapter<Money, ListMoneyAdapter.ListMoneyHolder> {

    private OnItemClickListener<Money> onItemClickListener;

    private List<Money> listMoney = new ArrayList<>();

    @Override
    protected RecyclerView.ViewHolder createViewHolder(int viewType, View v) {
        return new ListMoneyAdapter.ListMoneyHolder(v);
    }

    public void setOnItemClickListener(OnItemClickListener<Money> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setListMoney(List<Money> listMoney){
        this.listMoney.addAll(listMoney);
    }

    @Override
    protected int getLayoutIdByType(int viewType) {
        return R.layout.item_indicator;
    }


    class ListMoneyHolder extends BaseViewHolder<Money, ItemIndicatorBinding> {

        View view;

        public ListMoneyHolder(View itemView) {
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
        public void bind(int position, final Money item) {
            binder.tvName.setText(item.nombre);
            binder.tvValor.setText(item.valor);
        }
    }

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
    }

}
