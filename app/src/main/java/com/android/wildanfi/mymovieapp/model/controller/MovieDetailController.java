package com.android.wildanfi.mymovieapp.model.controller;

import com.android.wildanfi.mymovieapp.model.MovieDetail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WildanFI on 24/01/2018.
 */
import io.realm.Realm;

public class MovieDetailController {

    Realm realm;

    public void insert(MovieDetail movie){
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.insert(movie);
        realm.commitTransaction();
    }

    public List<MovieDetail> getAll(){
        realm = Realm.getDefaultInstance();
        List<MovieDetail> movies = new ArrayList<>();
        movies.addAll(realm.where(MovieDetail.class).findAll());
        return movies;
    }

    public boolean isExist(int id){
        realm = Realm.getDefaultInstance();
        MovieDetail movie;
        movie = realm.where(MovieDetail.class).equalTo("id", id).findFirst();
        if(movie == null) return false;
        else return true;
    }

    public void delete(int id){
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.where(MovieDetail.class).equalTo("id", id).findFirst().deleteFromRealm();
        realm.commitTransaction();
    }
}
