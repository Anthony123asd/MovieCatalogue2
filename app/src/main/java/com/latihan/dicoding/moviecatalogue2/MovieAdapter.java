package com.latihan.dicoding.moviecatalogue2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{
    private ArrayList<Movie> movies = new ArrayList<>();
    private Context context;

    public MovieAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_movie, parent, false);
        return new MovieAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.movieTitle.setText(movies.get(i).getTitle());
        viewHolder.movieDate.setText(movies.get(i).getDate());
        viewHolder.movieDescription.setText(movies.get(i).getDescription());
        Glide.with(context)
                .load(movies.get(i).getPoster())
                .apply(new RequestOptions().override(120, 155))
                .into(viewHolder.moviePoster);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView movieTitle;
        TextView movieDate;
        TextView movieDescription;
        ImageView moviePoster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movieTitle = itemView.findViewById(R.id.movie_title);
            movieDate = itemView.findViewById(R.id.movie_date);
            movieDescription = itemView.findViewById(R.id.movie_description);
            moviePoster = itemView.findViewById(R.id.movie_poster);
        }
    }


}
