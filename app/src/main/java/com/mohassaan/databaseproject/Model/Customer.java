package com.mohassaan.databaseproject.Model;

public class Customer {
    private String name;
    private String email;
    private String movie_title;
    private String movie_price;


    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Customer(String name, String email, String movie_title, String movie_price) {
        this.name = name;
        this.email = email;
        this.movie_title = movie_title;
        this.movie_price = movie_price;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public String getMovie_price() {
        return movie_price;
    }

    public void setMovie_price(String movie_price) {
        this.movie_price = movie_price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
