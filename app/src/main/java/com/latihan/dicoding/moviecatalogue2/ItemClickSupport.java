package com.latihan.dicoding.moviecatalogue2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

public class ItemClickSupport {
    private final RecyclerView recyclerView;

    private OnItemClickListener onItemClickListener;
    public interface OnItemClickListener{
        void onItemClicked(RecyclerView recyclerView, int position, View v);
    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder holder = recyclerView.getChildViewHolder(v);
            onItemClickListener.onItemClicked(recyclerView, holder.getAdapterPosition(), v);
        }
    };

    private RecyclerView.OnChildAttachStateChangeListener attachStateChangeListener
            = new RecyclerView.OnChildAttachStateChangeListener() {
        @Override
        public void onChildViewAttachedToWindow(@NonNull View view) {
            if (onItemClickListener != null) {
                view.setOnClickListener(onClickListener);
            }
        }

        @Override
        public void onChildViewDetachedFromWindow(@NonNull View view) {

        }
    };

    public ItemClickSupport(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        this.recyclerView.setTag(R.id.item_click_support, this);
        this.recyclerView.addOnChildAttachStateChangeListener(attachStateChangeListener);
    }

    public static ItemClickSupport addTo(RecyclerView recyclerView) {
        ItemClickSupport support = (ItemClickSupport) recyclerView.getTag(R.id.item_click_support);
        if (support == null) {
            support = new ItemClickSupport(recyclerView);
        }
        return support;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }
}
