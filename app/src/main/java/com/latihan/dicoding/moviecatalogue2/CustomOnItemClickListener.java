package com.latihan.dicoding.moviecatalogue2;

import android.support.annotation.NonNull;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;

public class CustomOnItemClickListener implements View.OnClickListener {
    private int position;
    private OnItemClickCallback onItemClickCallback;
    CustomOnItemClickListener(int position, OnItemClickCallback onItemClickCallback) {
        this.position = position;
        this.onItemClickCallback = onItemClickCallback;
    }
    @Override
    public void onClick(View view) {
        onItemClickCallback.onItemClicked(view, position);
    }
    public interface OnItemClickCallback {
        void onItemClicked(View view, int position);
    }
}