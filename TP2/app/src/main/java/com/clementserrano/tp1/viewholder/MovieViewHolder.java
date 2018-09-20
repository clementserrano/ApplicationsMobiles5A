package com.clementserrano.tp1.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.clementserrano.tp1.R;
import com.clementserrano.tp1.model.MovieList;

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
    public void layoutForMovieList(MovieList movieList) {
        if (movieList != null) {
            if (this.mMovieImage != null) {
                mMovieImage.setImageResource(movieList.getImage());
            }
            if (this.mMovieListTitle != null) {
                mMovieListTitle.setText(movieList.getName());
            }
            if (this.mMovieListDesc != null) {
                mMovieListDesc.setText(movieList.getDesc());
            }
        }
    }
}
