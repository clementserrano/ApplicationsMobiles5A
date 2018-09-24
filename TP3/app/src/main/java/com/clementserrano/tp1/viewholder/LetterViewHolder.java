package com.clementserrano.tp1.viewholder;

import android.view.View;
import android.widget.TextView;

import com.clementserrano.tp1.R;
import com.clementserrano.tp1.model.MovieList;

public class LetterViewHolder extends MovieListViewHolder {
    private TextView mMovieLetter;

    public LetterViewHolder(View itemView) {
        super(itemView);
        this.mMovieLetter = itemView.findViewById(R.id.movieListLetter);
    }

    @Override
    public void layoutForMovieList(MovieList movieList) {
        if (movieList != null) {
            if (this.mMovieLetter != null) {
                mMovieLetter.setText(movieList.getName());
            }
        }
    }
}
