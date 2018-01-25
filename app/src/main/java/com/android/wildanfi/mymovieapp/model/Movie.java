package com.android.wildanfi.mymovieapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by WildanFI on 24/01/2018.
 */

public class Movie {
    private int id;
    private String title;
    @SerializedName("poster_path")
    private String image;
    @SerializedName("backdrop_path")
    private String backdrop;

    public String getBackdrop() {
        return backdrop;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }
}
