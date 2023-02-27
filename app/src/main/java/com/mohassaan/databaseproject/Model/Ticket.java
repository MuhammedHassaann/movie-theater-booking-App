package com.mohassaan.databaseproject.Model;

public class Ticket {
    private String customer_name;
    private String movie_title;
    private String movie_price;

    public Ticket(String customer_name, String movie_title, String movie_price) {
        this.customer_name = customer_name;
        this.movie_title = movie_title;
        this.movie_price = movie_price;
    }

    public Ticket(String movie_title, String movie_price) {
        this.movie_title = movie_title;
        this.movie_price = movie_price;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
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
}
