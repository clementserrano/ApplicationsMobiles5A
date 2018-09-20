package com.clementserrano.tp1.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.clementserrano.tp1.R;
import com.clementserrano.tp1.model.MovieList;
import com.clementserrano.tp1.viewholder.FooterViewHolder;
import com.clementserrano.tp1.viewholder.LetterViewHolder;
import com.clementserrano.tp1.viewholder.MovieListViewHolder;
import com.clementserrano.tp1.viewholder.MovieViewHolder;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter {

    final int MOVIE_CELL = 0;
    final int LETTER_CELL = 1;
    final int FOOTER_CELL = 2;

    private List<MovieList> mMovieLists;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == MOVIE_CELL) {
            View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie, parent, false);
            MovieViewHolder vh = new MovieViewHolder(mView);
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
        MovieList currentMovieList = mMovieLists.get(position);
        if (holder instanceof MovieListViewHolder && currentMovieList != null) {
            MovieListViewHolder viewHolder = (MovieListViewHolder) holder;
            viewHolder.layoutForMovieList(currentMovieList);
        }
    }

    @Override
    public int getItemCount() {
        if (mMovieLists != null) {
            return mMovieLists.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (mMovieLists != null) {
            MovieList movieList = mMovieLists.get(position);
            switch (movieList.getType()) {
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

    public void setmMovieLists(List<MovieList> mMovieLists) {
        this.mMovieLists = mMovieLists;
    }
}
