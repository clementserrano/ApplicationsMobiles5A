package com.clementserrano.tp1.model;

import com.clementserrano.tp1.util.MovieListEnum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Movie implements Serializable {
    private int id;
    private String title;
    private String originalTitle;
    private int image;
    private String desc;
    private String keywords;
    private String category;
    private List<Comment> comments;
    private MovieListEnum type;

    public Movie(String title, MovieListEnum type) {
        this.title = title;
        this.type = type;
    }

    public Movie(int id, String title, String originalTitle, int image, String desc, String keywords, String category, MovieListEnum type) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.image = image;
        this.desc = desc;
        this.keywords = keywords;
        this.category = category;
        this.type = type;

        this.comments = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return title;
    }

    public int getImage() {
        return image;
    }

    public String getDesc() {
        return desc;
    }

    public MovieListEnum getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getCategory() {
        return category;
    }

    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + title + '\'' +
                '}';
    }
}
