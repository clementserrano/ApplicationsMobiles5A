package com.clementserrano.tp1.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.clementserrano.tp1.R;
import com.clementserrano.tp1.adapter.MovieListAdapter;
import com.clementserrano.tp1.manager.MovieManager;
import com.clementserrano.tp1.model.Movie;
import com.clementserrano.tp1.util.MovieListEnum;

import java.util.List;
import java.util.stream.Collectors;

public class MovieListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<Movie> mMovies;

    private Button backButton;
    private ImageButton crossButton;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        this.mRecyclerView = findViewById(R.id.movieList);
        this.backButton = findViewById(R.id.backTitle);
        this.crossButton = findViewById(R.id.cross);

        this.backButton.setOnClickListener(clickBack);
        this.crossButton.setOnClickListener(clickExit);

        mMovies = MovieManager.getInstance().getMovies();
        this.sortMovieList();

        MovieListAdapter movieListAdapter = new MovieListAdapter();
        movieListAdapter.setmMovies(mMovies);
        this.mRecyclerView.setAdapter(movieListAdapter);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.mRecyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent i = getIntent();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void sortMovieList() {
        mMovies = mMovies.stream().sorted((movie1, movie2) -> movie1.getName()
                .toLowerCase().compareTo(movie2.getName().toLowerCase())).collect(Collectors.toList());

        String letter = "";
        int nbMovies = 0;
        for (int i = 0; i < mMovies.size(); i++) {
            if (mMovies.get(i).getType() == MovieListEnum.MOVIE) {
                String currentLetter = mMovies.get(i).getName().substring(0, 1);

                if (letter.equals("")) {
                    mMovies.add(i, new Movie(currentLetter, MovieListEnum.LETTER));
                    letter = currentLetter;
                } else if (!letter.equals(currentLetter)) {
                    String footer = nbMovies + (nbMovies == 1 ? " film" : " films");
                    mMovies.add(i, new Movie(footer, MovieListEnum.FOOTER));
                    mMovies.add(i + 1, new Movie(currentLetter, MovieListEnum.LETTER));
                    letter = currentLetter;
                    nbMovies = 0;
                } else {
                    nbMovies++;
                }
            }
        }
        if (mMovies.size() != 0) {
            String footer = nbMovies + (nbMovies == 1 ? " film" : " films");
            mMovies.add(new Movie(footer, MovieListEnum.FOOTER));
        }
        System.out.println("");
    }

    private View.OnClickListener clickBack = v -> {
        Intent intent = new Intent(MovieListActivity.this, CategoryActivity.class);
        startActivity(intent);
    };

    private View.OnClickListener clickExit = v -> {
        finish();
        System.exit(0);
    };
}
