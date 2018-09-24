package com.clementserrano.tp1.manager;

import com.clementserrano.tp1.R;
import com.clementserrano.tp1.model.Category;
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
        movies.add(new Movie("Star Wars IV", R.drawable.star_wars, "Il y a bien longtemps, dans une galaxie très lointaine...", MovieListEnum.MOVIE));
        movies.add(new Movie("Le Seigneur des anneaux", R.drawable.star_wars, "...", MovieListEnum.MOVIE));
        movies.add(new Movie("Star Wars V", R.drawable.star_wars, "...", MovieListEnum.MOVIE));
        movies.add(new Movie("Star Wars VI", R.drawable.star_wars, "...", MovieListEnum.MOVIE));
        movies.add(new Movie("Fast & Furious", R.drawable.star_wars, "...", MovieListEnum.MOVIE));
        movies.add(new Movie("Deadpool", R.drawable.star_wars, "...", MovieListEnum.MOVIE));
        movies.add(new Movie("Avenger", R.drawable.star_wars, "...", MovieListEnum.MOVIE));

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

    public Movie getMovieById(int id) {
        return movies.get(id);
    }

    public List<Category> getCategories() {
        return categories;
    }
}
