package com.latihan.dicoding.moviecatalogue2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

public class TvShowDetail extends AppCompatActivity {

    public static final String TVSHOW_DETAIL = "TvShow DETAIL";
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

        TvShow TvShowDetail = getIntent().getParcelableExtra(TVSHOW_DETAIL);

        posterDetail.setImageResource(TvShowDetail.getPoster());
        dateDetail.setText(TvShowDetail.getDate());
        descriptionDetail.setText(TvShowDetail.getDescription());
        Toolbar toolbar = findViewById(R.id.toolbar_detail);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(TvShowDetail.getTitle());
    }
}
