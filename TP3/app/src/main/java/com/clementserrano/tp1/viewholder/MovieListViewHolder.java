package com.clementserrano.tp1.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.clementserrano.tp1.model.Movie;

public abstract class MovieListViewHolder extends RecyclerView.ViewHolder {

    public MovieListViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void layoutForMovieList(Movie movie);
}
