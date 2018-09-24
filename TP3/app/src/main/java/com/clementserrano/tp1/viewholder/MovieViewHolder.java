package com.clementserrano.tp1.viewholder;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.clementserrano.tp1.R;
import com.clementserrano.tp1.activity.MainActivity;
import com.clementserrano.tp1.activity.MovieListActivity;
import com.clementserrano.tp1.model.Movie;

public class MovieViewHolder extends MovieListViewHolder {

    private ImageView mMovieImage;
    private TextView mMovieListTitle;
    private TextView mMovieListDesc;
    private ImageButton mMovieButton;
    private Movie movie;

    private MovieListActivity movieListActivity;

    public MovieViewHolder(View itemView) {
        super(itemView);
        this.mMovieImage = itemView.findViewById(R.id.movieListImage);
        this.mMovieListTitle = itemView.findViewById(R.id.movieListTitle);
        this.mMovieListDesc = itemView.findViewById(R.id.movieListDesc);
        this.mMovieButton = itemView.findViewById(R.id.movieListButton);
    }

    @Override
    public void layoutForMovieList(Movie movie) {
        this.movie = movie;
        if (movie != null) {
            if (this.mMovieImage != null) {
                mMovieImage.setImageResource(movie.getImage());
            }
            if (this.mMovieListTitle != null) {
                mMovieListTitle.setText(movie.getName());
            }
            if (this.mMovieListDesc != null) {
                mMovieListDesc.setText(movie.getDesc());
            }
            if (this.mMovieButton != null) {
                mMovieButton.setOnClickListener(clickMovie);
            }
        }
    }

    private View.OnClickListener clickMovie = v -> {
        movieListActivity.clickMovie(movie);
    };

    public void setMovieListActivity(MovieListActivity movieListActivity) {
        this.movieListActivity = movieListActivity;
    }
}
