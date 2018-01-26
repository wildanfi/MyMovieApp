package com.android.wildanfi.mymovieapp.view;

import com.android.wildanfi.mymovieapp.model.MovieDetail;

import java.util.List;

/**
 * Created by WildanFI on 26/01/2018.
 */

public interface FavoriteView {
    void onDataFound(List<MovieDetail> movies);

    void onNoFavorite();
}
