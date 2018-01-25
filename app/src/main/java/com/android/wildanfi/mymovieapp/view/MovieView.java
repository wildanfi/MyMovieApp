package com.android.wildanfi.mymovieapp.view;

import com.android.wildanfi.mymovieapp.model.Movie;

import java.util.List;

/**
 * Created by WildanFI on 24/01/2018.
 */

public interface MovieView {
    void onMoviesFound(List<Movie> movies);

    void setTotalPages(int pages);

    void onError(String message);
}
