package com.android.wildanfi.mymovieapp.modul.viewholder;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.wildanfi.mymovieapp.R;
import com.android.wildanfi.mymovieapp.adapter.MovieAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by WildanFI on 24/01/2018.
 */

public class MovieViewHolder extends RecyclerView.ViewHolder {
    private Context context;
    @BindView(R.id.root_layout)
    ConstraintLayout rootLayout;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.tv_title)
    TextView title;
    private MovieAdapter callback;

    public MovieViewHolder(View itemView, Context context, final MovieAdapter callback) {
        super(itemView);
        this.context = context;
        this.callback = callback;
        ButterKnife.bind(this, itemView);
        rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(callback.getSetOnItemClickListener() != null)
                    callback.getSetOnItemClickListener().onClick(view, getAdapterPosition());
            }
        });
    }

    public ImageView getImage() {
        return image;
    }

    public TextView getTitle() {
        return title;
    }
}
