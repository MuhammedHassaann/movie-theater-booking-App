package com.mohassaan.databaseproject.Model;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class Movie {
    private String title;
    private String rating;
    private String genre;
    private String year;
    private String price;
    private Bitmap movieImage;

    public Movie(String title, String rating, String genre, String year, String price, Bitmap movieImage) {
        this.title = title;
        this.rating = rating;
        this.genre = genre;
        this.year = year;
        this.price = price;
        this.movieImage = movieImage;
    }

    public Movie(String title, String rating, String genre, String year,String price) {
        this.title = title;
        this.rating = rating;
        this.genre = genre;
        this.year = year;
        this.price=price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public Bitmap getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(Bitmap movieImage) {
        this.movieImage = movieImage;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
