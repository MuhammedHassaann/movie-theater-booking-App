package com.mohassaan.databaseproject.Adapters;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mohassaan.databaseproject.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    CardView cv_movie;
    ImageView movieImageView;
    TextView movieTitle,movieRating,movieGenre,movieYear,moviePrice;
    Button buyButton;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        cv_movie=itemView.findViewById(R.id.cv_movie);
        movieImageView=itemView.findViewById(R.id.movie_ImageView);
        movieTitle=itemView.findViewById(R.id.movie_title_txt);
        movieRating=itemView.findViewById(R.id.movie_rating_txt);
        movieGenre=itemView.findViewById(R.id.movie_genre_txt);
        movieYear=itemView.findViewById(R.id.movie_year_txt);
        moviePrice=itemView.findViewById(R.id.movie_price_txt);
        buyButton=itemView.findViewById(R.id.buy_button);

    }
}

