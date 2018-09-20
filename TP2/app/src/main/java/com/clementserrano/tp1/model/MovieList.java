package com.clementserrano.tp1.model;

import com.clementserrano.tp1.util.MovieListEnum;

public class MovieList {
    String name;
    int image;
    String desc;
    MovieListEnum type;

    public String getName() {
        return name;
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

    public MovieList(String name, int image, String desc, MovieListEnum type) {
        this.name = name;
        this.image = image;
        this.desc = desc;
        this.type = type;
    }

    @Override
    public String toString() {
        return "MovieList{" +
                "name='" + name + '\'' +
                ", image=" + image +
                ", desc='" + desc + '\'' +
                ", type=" + type +
                '}';
    }
}
