package com.clementserrano.tp1.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.clementserrano.tp1.R;
import com.clementserrano.tp1.model.Movie;

public class MovieViewHolder extends MovieListViewHolder {

    private ImageView mMovieImage;
    private TextView mMovieListTitle;
    private TextView mMovieListDesc;

    public MovieViewHolder(View itemView) {
        super(itemView);
        this.mMovieImage = itemView.findViewById(R.id.movieListImage);
        this.mMovieListTitle = itemView.findViewById(R.id.movieListTitle);
        this.mMovieListDesc = itemView.findViewById(R.id.movieListDesc);
    }

    @Override
    public void layoutForMovieList(Movie movie) {
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
        }
    }
}
