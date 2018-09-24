package com.clementserrano.tp1.viewholder;

import android.view.View;
import android.widget.TextView;

import com.clementserrano.tp1.R;
import com.clementserrano.tp1.model.Movie;

public class LetterViewHolder extends MovieListViewHolder {
    private TextView mMovieLetter;

    public LetterViewHolder(View itemView) {
        super(itemView);
        this.mMovieLetter = itemView.findViewById(R.id.movieListLetter);
    }

    @Override
    public void layoutForMovieList(Movie movie) {
        if (movie != null) {
            if (this.mMovieLetter != null) {
                mMovieLetter.setText(movie.getName());
            }
        }
    }
}
