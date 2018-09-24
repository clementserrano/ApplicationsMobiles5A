package com.clementserrano.tp1.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.clementserrano.tp1.R;
import com.clementserrano.tp1.activity.MovieListActivity;
import com.clementserrano.tp1.model.Movie;
import com.clementserrano.tp1.viewholder.FooterViewHolder;
import com.clementserrano.tp1.viewholder.LetterViewHolder;
import com.clementserrano.tp1.viewholder.MovieListViewHolder;
import com.clementserrano.tp1.viewholder.MovieViewHolder;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter {

    final int MOVIE_CELL = 0;
    final int LETTER_CELL = 1;
    final int FOOTER_CELL = 2;

    private List<Movie> mMovies;

    private MovieListActivity movieListActivity;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == MOVIE_CELL) {
            View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie, parent, false);
            MovieViewHolder vh = new MovieViewHolder(mView);
            vh.setMovieListActivity(movieListActivity);
            return vh;
        } else if (viewType == LETTER_CELL) {
            View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.letter, parent, false);
            LetterViewHolder vh = new LetterViewHolder(mView);
            return vh;
        } else if (viewType == FOOTER_CELL) {
            View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.footer, parent, false);
            FooterViewHolder vh = new FooterViewHolder(mView);
            return vh;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Movie currentMovie = mMovies.get(position);
        if (holder instanceof MovieListViewHolder && currentMovie != null) {
            MovieListViewHolder viewHolder = (MovieListViewHolder) holder;
            viewHolder.layoutForMovieList(currentMovie);
        }
    }

    @Override
    public int getItemCount() {
        if (mMovies != null) {
            return mMovies.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (mMovies != null) {
            Movie movie = mMovies.get(position);
            switch (movie.getType()) {
                case MOVIE:
                    return MOVIE_CELL;
                case LETTER:
                    return LETTER_CELL;
                case FOOTER:
                    return FOOTER_CELL;
            }
        }
        return 0;
    }

    public void setmMovies(List<Movie> mMovies) {
        this.mMovies = mMovies;
    }

    public List<Movie> getmMovies() {
        return mMovies;
    }

    public void setMovieListActivity(MovieListActivity movieListActivity) {
        this.movieListActivity = movieListActivity;
    }
}
