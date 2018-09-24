package com.clementserrano.tp1.viewholder;

import android.view.View;
import android.widget.TextView;

import com.clementserrano.tp1.R;
import com.clementserrano.tp1.model.Movie;

public class FooterViewHolder extends MovieListViewHolder {
    private TextView mMovieFooter;

    public FooterViewHolder(View itemView) {
        super(itemView);
        this.mMovieFooter = itemView.findViewById(R.id.movieListFooter);
    }

    @Override
    public void layoutForMovieList(Movie movie) {
        if (movie != null) {
            if (this.mMovieFooter != null) {
                mMovieFooter.setText(movie.getName());
            }
        }
    }
}