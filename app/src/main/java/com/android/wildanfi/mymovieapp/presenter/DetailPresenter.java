package com.android.wildanfi.mymovieapp.presenter;

import com.android.wildanfi.mymovieapp.model.MovieDetail;
import com.android.wildanfi.mymovieapp.model.controller.MovieDetailController;
import com.android.wildanfi.mymovieapp.view.DetailView;
import com.android.wildanfi.mymovieapp.util.App;
import com.android.wildanfi.mymovieapp.util.Constant;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by WildanFI on 24/01/2018.
 */

public class DetailPresenter {
    private DetailView view;
    private MovieDetailController controller;

    public DetailPresenter() {
        controller = new MovieDetailController();
    }

    public void loadDetail(int id){
        getView().onLoading();
        Call<MovieDetail> call = App.getInstance().getApi().getDetail(id, Constant.Api.API_KEY);
        call.enqueue(new Callback<MovieDetail>() {
            @Override
            public void onResponse(Call<MovieDetail> call, Response<MovieDetail> response) {
                if(response.isSuccessful()){
                    if (response.body() != null){
                        getView().onLoadData(response.body());
                        getView().onNoLoading();
                    }else {
                        getView().onError("Failed to get movie detail");
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieDetail> call, Throwable t) {
                getView().onError("Server Failure: " + t.getMessage());
            }
        });
    }

    public DetailView getView() {
        return view;
    }

    public void setView(DetailView view) {
        this.view = view;
    }

    public void checkFavorite(int id) {
        getView().setFavorite(controller.isExist(id));
    }

    public void setFavorite(boolean favorite, MovieDetail movie) {
        if(favorite){
            controller.insert(movie);
            getView().setFavorite(true);
        }else {
            controller.delete(movie.getId());
            getView().setFavorite(false);
        }
    }
}
