package com.android.wildanfi.mymovieapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.wildanfi.mymovieapp.R;
import com.android.wildanfi.mymovieapp.model.Genre;
import com.android.wildanfi.mymovieapp.model.MovieDetail;
import com.android.wildanfi.mymovieapp.presenter.DetailPresenter;
import com.android.wildanfi.mymovieapp.view.DetailView;
import com.android.wildanfi.mymovieapp.util.Constant;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by WildanFI on 24/01/2018.
 */

public class MovieDetailActivity extends AppCompatActivity implements DetailView {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.btn_favorite)
    ImageView favorite;
    @BindView(R.id.header)
    ImageView header;
    @BindView(R.id.poster)
    ImageView poster;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.genre)
    TextView genre;
    @BindView(R.id.language)
    TextView language;
    @BindView(R.id.rating)
    TextView rating;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.duration)
    TextView duration;
    @BindView(R.id.loading)
    RelativeLayout loading;
    private int id;

    private boolean favorited;

    private DetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        setSupportActionBar(toolbar);
        presenter = new DetailPresenter();
        presenter.setView(this);
        ButterKnife.bind(this);
        id = getIntent().getIntExtra("id", 1);
        presenter.loadDetail(id);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.movie, menu);
        return true;
    }

    @Override
    public void onLoadData(final MovieDetail movie) {
        toolbar.setTitle(movie.getTitle());
        Glide.with(this).load(Constant.Api.IMAGE_PATH + movie.getHeader()).into(header);
        Glide.with(this).load(Constant.Api.IMAGE_PATH + movie.getPoster()).into(poster);
        description.setText(movie.getDescription());
        String genres = "";
        for(Genre genre : movie.getGenres()){
            if("".equals(genres)) genres = genre.getGenreName();
            else genres += ", " + genre.getGenreName();
        }
        genre.setText(genres);
        language.setText(movie.getLanguage().get(0).getLanguageCode() + " - " +
                movie.getLanguage().get(0).getLanguageName());
        rating.setText(movie.getRating() + " / 10");
        date.setText(movie.getDate().toLocaleString().substring(0, 12));
        int hour = 0;
        int minute = 0;
        String durationString = "";
        if(movie.getDuration() > 60){
            hour = movie.getDuration() / 60;
            minute = movie.getDuration() - (60 * hour);
            durationString = hour + "h " + minute + "m";
        }else {
            durationString = minute + "m";
        }
        duration.setText(durationString);
        presenter.checkFavorite(movie.getId());
        favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(favorited) presenter.setFavorite(false, movie);
                else presenter.setFavorite(true, movie);
            }
        });
    }

    @Override
    public void onError(String messsage) {
        Toast.makeText(this, messsage, Toast.LENGTH_LONG);
    }

    @Override
    public void setFavorite(boolean favorite) {
        favorited = favorite;
        if(favorite) this.favorite.setImageDrawable(getResources().getDrawable(R.drawable.ic_favorited));
        else this.favorite.setImageDrawable(getResources().getDrawable(R.drawable.ic_unfavorite));
    }

    @Override
    public void onLoading() {
        loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void onNoLoading() {
        loading.setVisibility(View.GONE);
    }
}