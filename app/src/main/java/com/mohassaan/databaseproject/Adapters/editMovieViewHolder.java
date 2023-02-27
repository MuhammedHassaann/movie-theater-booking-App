package com.mohassaan.databaseproject.Adapters;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mohassaan.databaseproject.R;

public class editMovieViewHolder extends RecyclerView.ViewHolder {

    CardView cv_movie_forAdmin;
    ImageView movie_ImageView_forAdmin,delete,edit;
    TextView movie_title_txt_forAdmin,movie_rating_txt_forAdmin,
            movie_genre_txt_forAdmin,movie_year_txt_forAdmin,movie_price_txt_forAdmin;
    public editMovieViewHolder(@NonNull View itemView) {
        super(itemView);
        cv_movie_forAdmin =itemView.findViewById(R.id.cv_movie_forAdmin);
        movie_ImageView_forAdmin =itemView.findViewById(R.id.movie_ImageView_forAdmin);
        delete =itemView.findViewById(R.id.delete);
        edit = itemView.findViewById(R.id.edit);
        movie_title_txt_forAdmin =itemView.findViewById(R.id.movie_title_txt_forAdmin);
        movie_rating_txt_forAdmin =itemView.findViewById(R.id.movie_rating_txt_forAdmin);
        movie_genre_txt_forAdmin =itemView.findViewById(R.id.movie_genre_txt_forAdmin);
        movie_year_txt_forAdmin =itemView.findViewById(R.id.movie_year_txt_forAdmin);
        movie_price_txt_forAdmin =itemView.findViewById(R.id.movie_price_txt_forAdmin);
    }
}
