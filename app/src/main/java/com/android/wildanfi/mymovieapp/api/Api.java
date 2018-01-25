package com.android.wildanfi.mymovieapp.api;

import com.android.wildanfi.mymovieapp.model.MovieDetail;
import com.android.wildanfi.mymovieapp.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by WildanFI on 24/01/2018.
 */

public interface Api {
    @GET("now_playing")
    Call<MovieResponse> getNowPlaying(
            @Query("api_key") String apiKey,
            @Query("page") int page
    );

    @GET("top_rated")
    Call<MovieResponse> getTopRated(
            @Query("api_key") String apiKey,
            @Query("page") int page
    );

    @GET("upcoming")
    Call<MovieResponse> getUpcoming(
            @Query("api_key") String apiKey,
            @Query("page") int page
    );

    @GET("popular")
    Call<MovieResponse> getPopular(
            @Query("api_key") String apiKey,
            @Query("page") int page
    );

    @GET("{movie_id}")
    Call<MovieDetail> getDetail(
            @Path("movie_id") int id,
            @Query("api_key") String apiKey
    );
}
