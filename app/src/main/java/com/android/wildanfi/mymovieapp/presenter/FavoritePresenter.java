package com.android.wildanfi.mymovieapp.presenter;

import com.android.wildanfi.mymovieapp.model.MovieDetail;
import com.android.wildanfi.mymovieapp.model.controller.MovieDetailController;
import com.android.wildanfi.mymovieapp.view.FavoriteView;

import java.util.List;

/**
 * Created by WildanFI on 26/01/2018.
 */

public class FavoritePresenter {FavoriteView view;
    MovieDetailController controller;

    public FavoritePresenter() {
        controller = new MovieDetailController();
    }

    public void loadFavorite(){
        List<MovieDetail> movies = controller.getAll();
        if(movies != null && !movies.isEmpty()){
            getView().onDataFound(movies);
        }else {
            getView().onNoFavorite();
        }
    }

    public FavoriteView getView() {
        return view;
    }

    public void setView(FavoriteView view) {
        this.view = view;
    }
}
