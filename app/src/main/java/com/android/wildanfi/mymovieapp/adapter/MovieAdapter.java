package com.android.wildanfi.mymovieapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.wildanfi.mymovieapp.R;
import com.android.wildanfi.mymovieapp.model.Movie;
import com.android.wildanfi.mymovieapp.modul.viewholder.MovieViewHolder;
import com.bumptech.glide.Glide;

import java.util.List;

import static com.android.wildanfi.mymovieapp.util.Constant.Api.IMAGE_PATH;

/**
 * Created by WildanFI on 24/01/2018.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    private List<Movie> movies;
    private Context context;
    private SetOnItemClickListener setOnItemClickListener;
    private OnLoadMoreListener onLoadMoreListener;

    public MovieAdapter(List<Movie> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    public void setSetOnItemClickListener(SetOnItemClickListener setOnItemClickListener) {
        this.setOnItemClickListener = setOnItemClickListener;
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    public OnLoadMoreListener getOnLoadMoreListener() {
        return onLoadMoreListener;
    }

    public SetOnItemClickListener getSetOnItemClickListener() {
        return setOnItemClickListener;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view, parent.getContext(), this);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie movie = movies.get(position);
        Glide.with(context).load(IMAGE_PATH + movie.getImage()).into(holder.getImage());
        holder.getTitle().setText(movie.getTitle());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public interface SetOnItemClickListener{
        public void onClick(View view, int position);
    }

    public interface OnLoadMoreListener{
        void onLoadMore();
    }
}
