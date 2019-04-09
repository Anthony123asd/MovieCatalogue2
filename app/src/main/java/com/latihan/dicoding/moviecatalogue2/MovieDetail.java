package com.latihan.dicoding.moviecatalogue2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

public class MovieDetail extends AppCompatActivity {

    public static final String MOVIE_DETAIL = "MOVIE DETAIL";
    ImageView posterDetail;
    TextView dateDetail;
    TextView descriptionDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        posterDetail = findViewById(R.id.movie_poster_detail);
        dateDetail = findViewById(R.id.movie_date_detail);
        descriptionDetail = findViewById(R.id.movie_description_detail);

        Movie movieDetail = getIntent().getParcelableExtra(MOVIE_DETAIL);

        posterDetail.setImageResource(movieDetail.getPoster());
        dateDetail.setText(movieDetail.getDate());
        descriptionDetail.setText(movieDetail.getDescription());
        Toolbar toolbar = findViewById(R.id.toolbar_detail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(movieDetail.getTitle());
    }
}
