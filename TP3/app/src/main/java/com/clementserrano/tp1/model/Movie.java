package com.clementserrano.tp1.model;

import com.clementserrano.tp1.util.MovieListEnum;

public class Movie {
    private String title;
    private String originalTitle;
    private int image;
    private String desc;
    private String keywords;
    private MovieListEnum type;

    public Movie(String name, int image, String desc, MovieListEnum type) {
        this.title = name;
        this.image = image;
        this.desc = desc;
        this.type = type;
    }

    public Movie(String title, String originalTitle, int image, String desc, String keywords) {
        this.title = title;
        this.originalTitle = originalTitle;
        this.image = image;
        this.desc = desc;
        this.keywords = keywords;
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

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + title + '\'' +
                ", image=" + image +
                ", desc='" + desc + '\'' +
                ", type=" + type +
                '}';
    }
}
