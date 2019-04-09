package com.latihan.dicoding.moviecatalogue2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.ViewHolder>{
    private ArrayList<TvShow> tvShows = new ArrayList<>();
    private Context context;

    public TvShowAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public TvShowAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_tvshow, parent, false);
        return new TvShowAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvShowAdapter.ViewHolder viewHolder, int i) {
        viewHolder.tvShowTitle.setText(tvShows.get(i).getTitle());
        viewHolder.tvShowDate.setText(tvShows.get(i).getDate());
        viewHolder.tvShowDescription.setText(tvShows.get(i).getDescription());
        Glide.with(context)
                .load(tvShows.get(i).getPoster())
                .apply(new RequestOptions().override(120, 155))
                .into(viewHolder.tvShowPoster);
    }

    @Override
    public int getItemCount() {
        return tvShows.size();
    }

    public void setTvShows(ArrayList<TvShow> tvShows) {
        this.tvShows = tvShows;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvShowTitle;
        TextView tvShowDate;
        TextView tvShowDescription;
        ImageView tvShowPoster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvShowTitle = itemView.findViewById(R.id.tvshow_title);
            tvShowDate = itemView.findViewById(R.id.tvshow_date);
            tvShowDescription = itemView.findViewById(R.id.tvshow_description);
            tvShowPoster = itemView.findViewById(R.id.tvshow_poster);
        }
    }
}
