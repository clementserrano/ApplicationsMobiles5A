package com.clementserrano.tp1.manager;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.clementserrano.tp1.R;
import com.clementserrano.tp1.model.Category;
import com.clementserrano.tp1.model.Comment;
import com.clementserrano.tp1.model.Movie;
import com.clementserrano.tp1.util.MovieListEnum;

import java.util.ArrayList;
import java.util.List;

public class MovieManager {

    public static MovieManager instance = new MovieManager();

    private List<Movie> movies;
    private List<Category> categories;

    private MovieManager() {
        movies = new ArrayList<>();
        movies.add(new Movie(0, "La Guerre des étoiles IV", "Star Wars IV", R.drawable.star_wars, "Il y a bien longtemps, dans une galaxie très lointaine...", "Lightsaber, Jedi, Force, Father", "", MovieListEnum.MOVIE));
        movies.add(new Movie(1, "Le Seigneur des anneaux", "Lord Of The Rings", R.drawable.star_wars, "...", "...", "", MovieListEnum.MOVIE));
        movies.add(new Movie(2, "La Guerre des étoiles V", "Star Wars V", R.drawable.star_wars, "...", "...", "", MovieListEnum.MOVIE));
        movies.add(new Movie(3, "La Guerre des étoiles VI", "Star Wars VI", R.drawable.star_wars, "...", "...", "", MovieListEnum.MOVIE));
        movies.add(new Movie(4, "Rapide & Furieux", "Fast & Furious", R.drawable.star_wars, "...", "...", "", MovieListEnum.MOVIE));
        movies.add(new Movie(5, "Piscine morte", "Deadpool", R.drawable.star_wars, "...", "...", "", MovieListEnum.MOVIE));
        movies.add(new Movie(6, "Les Vengeurs", "Avenger", R.drawable.star_wars, "...", "...", "", MovieListEnum.MOVIE));

        movies.get(0).getComments().add(new Comment("Jean-Michel", "Film interstellaire !", R.drawable.pig));
        movies.get(0).getComments().add(new Comment("Jean-Michel", "Solo meurt dans le 7.", R.drawable.pig));

        categories = new ArrayList<>();
        categories.add(new Category("Comédie"));
        categories.add(new Category("Film d'horreur"));
        categories.add(new Category("Comédie"));
        categories.add(new Category("Action"));
        categories.add(new Category("Aventure"));
        categories.add(new Category("Documentaire"));
        categories.add(new Category("Pornographique"));
        categories.add(new Category("Humour"));
        categories.add(new Category("Policier"));
        categories.add(new Category("Drame"));
        categories.add(new Category("Thriller"));
        categories.add(new Category("Post-Apocalypse"));
        categories.add(new Category("Science-Fiction"));
        categories.add(new Category("Sport"));
        categories.add(new Category("Super Héros"));
    }

    public static MovieManager getInstance() {
        return instance;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    @SuppressLint("NewApi")
    @RequiresApi(api = Build.VERSION_CODES.N)
    public Movie getMovieById(int id) {
        return movies.stream().filter(m -> m.getId() == id).findFirst().get();
    }

    public List<Category> getCategories() {
        return categories;
    }
}
