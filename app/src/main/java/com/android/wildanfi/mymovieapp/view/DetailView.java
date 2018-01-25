package com.android.wildanfi.mymovieapp.view;

import com.android.wildanfi.mymovieapp.model.MovieDetail;

/**
 * Created by WildanFI on 24/01/2018.
 */

public interface DetailView {
    void onLoadData(MovieDetail movie);

    void onError(String messsage);

    void setFavorite(boolean favorite);

    void onLoading();

    void onNoLoading();
}
