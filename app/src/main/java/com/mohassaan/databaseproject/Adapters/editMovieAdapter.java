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

public class editMovieAdapter extends RecyclerView.Adapter<editMovieViewHolder>{

    private on_Click on_Click;
    private Context context;
    private List<Movie> movies;

    public editMovieAdapter(editMovieAdapter.on_Click on_Click, Context context, List<Movie> movies) {
        this.on_Click = on_Click;
        this.context = context;
        this.movies = movies;
    }

    public interface on_Click {
        public void onEditClick(Movie movie);
        public void onDeleteClick(Movie movie);
    }

    @NonNull
    @Override
    public editMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View myView = inflater.inflate(R.layout.root_editmovies,parent,false);
        return new editMovieViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull editMovieViewHolder holder, int position) {
        Movie movie=movies.get(position);
        holder.movie_ImageView_forAdmin.setImageBitmap(movie.getMovieImage());
        holder.movie_title_txt_forAdmin.setText(movie.getTitle());
        holder.movie_rating_txt_forAdmin.setText(movie.getRating());
        holder.movie_genre_txt_forAdmin.setText(movie.getGenre());
        holder.movie_year_txt_forAdmin.setText(movie.getYear());
        holder.movie_price_txt_forAdmin.setText(movie.getPrice());
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                on_Click.onEditClick(movie);

            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                on_Click.onDeleteClick(movie);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
