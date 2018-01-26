package com.android.wildanfi.mymovieapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.wildanfi.mymovieapp.R;
import com.android.wildanfi.mymovieapp.activity.MovieDetailActivity;
import com.android.wildanfi.mymovieapp.fragment.FavoriteFragment;
import com.android.wildanfi.mymovieapp.model.MovieDetail;
import com.android.wildanfi.mymovieapp.util.Constant;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by WildanFI on 26/01/2018.
 */

public class FavoriteRvAdapter extends RecyclerView.Adapter<FavoriteRvAdapter.ViewHolder> {

private final List<MovieDetail> mValues;
private final FavoriteFragment.OnListFragmentInteractionListener mListener;
private Context context;

public FavoriteRvAdapter(List<MovieDetail> items, FavoriteFragment.OnListFragmentInteractionListener listener,
        Context context) {
        mValues = items;
        mListener = listener;
        this.context = context;
        }

@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
        }

@Override
public void onBindViewHolder(final ViewHolder holder, final int position) {
//        holder.rating.setText(Constant.Api.RATING + mValues.get(position).getRating());
        holder.title.setText(mValues.get(position).getTitle());
        Glide.with(context).load(Constant.Api.IMAGE_PATH + mValues.get(position).getPoster())
        .into(holder.image);

        holder.rootLayout.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        if (null != mListener) {
        context.startActivity(new Intent(context, MovieDetailActivity.class)
        .putExtra("id", mValues.get(position).getId()).putExtra("jenis",
        Constant.FragmentChooser.FAVORITE));
        }
        }
        });
        }

@Override
public int getItemCount() {
        return mValues.size();
        }

public class ViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.root_layout)
    ConstraintLayout rootLayout;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.tv_title)
    TextView title;
//    @BindView(R.id.rating)
//    TextView rating;

    public ViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
}