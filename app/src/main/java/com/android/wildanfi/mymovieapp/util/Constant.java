package com.android.wildanfi.mymovieapp.util;

/**
 * Created by WildanFI on 24/01/2018.
 */

public interface Constant {
    interface Api{
        String BASE_URL = "https://Api.themoviedb.org/3/movie/";
        String API_KEY = "a937fc830d53c7f2b501028d20062caa";
        String IMAGE_PATH = "https://image.tmdb.org/t/p/w500";
    }
    interface FragmentChooser{
        String NOW_PLAYING = "Now Playing";
        String TOP_RATED = "Top Rated";
        String UPCOMING = "Upcoming";
        String POPULAR = "Popular";
        String ABOUT = "About";
    }
}
