package com.mohassaan.databaseproject.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mohassaan.databaseproject.Model.Movie;
import com.mohassaan.databaseproject.R;

import java.util.List;

public class allMoviesAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private onClick onClick;
    private Context context;
    private List<Movie> movies;
    public allMoviesAdapter(Context context, List<Movie> movies, onClick onClick) {
        this.context=context;
        this.movies=movies;
        this.onClick=onClick;
    }

    public interface onClick{
        public void onBuyButtonClick(Movie movie);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View myView = inflater.inflate(R.layout.root_movies,parent,false);
        return new MyViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie=movies.get(position);
        //holder.movieImageView.setImageBitmap(movie.getMovieImage());

        //**********************************************************************
        //To access image from drawable file
        holder.movieImageView.setImageBitmap(movie.getMovieImage());
        //**********************************************************************

        holder.movieTitle.setText(movie.getTitle());
        holder.movieRating.setText(movie.getRating());
        holder.movieGenre.setText(movie.getGenre());
        holder.movieYear.setText(movie.getYear());
        holder.moviePrice.setText(movie.getPrice());
        holder.buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick.onBuyButtonClick(movie);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


}
