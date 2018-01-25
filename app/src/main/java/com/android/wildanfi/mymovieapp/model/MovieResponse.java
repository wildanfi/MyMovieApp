package com.android.wildanfi.mymovieapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by WildanFI on 24/01/2018.
 */

public class MovieResponse {
    @SerializedName("results")
    private List<Movie> movies;
    @SerializedName("total_pages")
    private int totalPages;

    public List<Movie> getMovies() {
        return movies;
    }

    public int getTotalPages() {
        return totalPages;
    }
}
