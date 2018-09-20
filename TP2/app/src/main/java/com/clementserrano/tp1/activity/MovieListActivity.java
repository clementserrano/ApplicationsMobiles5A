package com.clementserrano.tp1.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.clementserrano.tp1.R;
import com.clementserrano.tp1.adapter.MovieListAdapter;
import com.clementserrano.tp1.model.MovieList;
import com.clementserrano.tp1.util.MovieListEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<MovieList> mMovieLists;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        this.mRecyclerView = findViewById(R.id.movieList);

        mMovieLists = new ArrayList<>();
        mMovieLists.add(new MovieList("Star Wars IV", R.drawable.star_wars, "Il y a bien longtemps, dans une galaxie très lointaine...", MovieListEnum.MOVIE));
        mMovieLists.add(new MovieList("Le Seigneur des anneaux", R.drawable.star_wars, "...", MovieListEnum.MOVIE));
        mMovieLists.add(new MovieList("Star Wars V", R.drawable.star_wars, "...", MovieListEnum.MOVIE));
        mMovieLists.add(new MovieList("Star Wars VI", R.drawable.star_wars, "...", MovieListEnum.MOVIE));
        mMovieLists.add(new MovieList("Fast & Furious", R.drawable.star_wars, "...", MovieListEnum.MOVIE));
        mMovieLists.add(new MovieList("Deadpool", R.drawable.star_wars, "...", MovieListEnum.MOVIE));
        mMovieLists.add(new MovieList("Avenger", R.drawable.star_wars, "...", MovieListEnum.MOVIE));
        this.sortMovieList();

        MovieListAdapter movieListAdapter = new MovieListAdapter();
        movieListAdapter.setmMovieLists(mMovieLists);
        this.mRecyclerView.setAdapter(movieListAdapter);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mRecyclerView.getAdapter().notifyDataSetChanged();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void sortMovieList() {
        mMovieLists = mMovieLists.stream().sorted((movie1, movie2) -> movie1.getName()
                .toLowerCase().compareTo(movie2.getName().toLowerCase())).collect(Collectors.toList());

        String letter = "";
        int nbMovies = 0;
        for (int i = 0; i < mMovieLists.size(); i++) {
            if (mMovieLists.get(i).getType() == MovieListEnum.MOVIE) {
                String currentLetter = mMovieLists.get(i).getName().substring(0, 1);

                if (letter.equals("")) {
                    mMovieLists.add(i, new MovieList(currentLetter, 0, "", MovieListEnum.LETTER));
                    letter = currentLetter;
                } else if (!letter.equals(currentLetter)) {
                    String footer = nbMovies + (nbMovies == 1 ? " film" : " films");
                    mMovieLists.add(i, new MovieList(footer, 0, "", MovieListEnum.FOOTER));
                    mMovieLists.add(i + 1, new MovieList(currentLetter, 0, "", MovieListEnum.LETTER));
                    letter = currentLetter;
                    nbMovies = 0;
                } else {
                    nbMovies++;
                }
            }
        }
        if (mMovieLists.size() != 0) {
            String footer = nbMovies + (nbMovies == 1 ? " film" : " films");
            mMovieLists.add(new MovieList(footer, 0, "", MovieListEnum.FOOTER));
        }
        System.out.println("");
    }
}
