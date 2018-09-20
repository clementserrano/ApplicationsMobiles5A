package com.clementserrano.tp1.viewholder;

import android.view.View;
import android.widget.TextView;

import com.clementserrano.tp1.R;
import com.clementserrano.tp1.model.MovieList;

public class FooterViewHolder extends MovieListViewHolder {
    private TextView mMovieFooter;

    public FooterViewHolder(View itemView) {
        super(itemView);
        this.mMovieFooter = itemView.findViewById(R.id.movieListFooter);
    }

    @Override
    public void layoutForMovieList(MovieList movieList) {
        if (movieList != null) {
            if (this.mMovieFooter != null) {
                mMovieFooter.setText(movieList.getName());
            }
        }
    }
}