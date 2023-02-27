package com.mohassaan.databaseproject.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.mohassaan.databaseproject.Adapters.allMoviesAdapter;
import com.mohassaan.databaseproject.Adapters.editMovieAdapter;
import com.mohassaan.databaseproject.Database.MovieDatabase;
import com.mohassaan.databaseproject.Model.Movie;
import com.mohassaan.databaseproject.R;

public class EditMovieActivity extends AppCompatActivity implements editMovieAdapter.on_Click {

    private RecyclerView recyclerView;
    MovieDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_movie);

        recyclerView=findViewById(R.id.rv_allMovies_forAdmin);

        db = new MovieDatabase(this);


        editMovieAdapter myAdapter = new editMovieAdapter(this,this,db.getAllMovies());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myAdapter);
    }


    @Override
    public void onEditClick(Movie movie) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.edit_dialog);
        dialog.setCancelable(false);
        EditText Movie_Title_ET_dialog = dialog.findViewById(R.id.Movie_Title_ET_dialog);
        EditText Movie_Rating_ET_dialog = dialog.findViewById(R.id.Movie_Rating_ET_dialog);
        EditText Movie_Genre_ET_dialog = dialog.findViewById(R.id.Movie_Genre_ET_dialog);
        EditText Movie_Year_ET_dialog = dialog.findViewById(R.id.Movie_Year_ET_dialog);
        EditText Movie_Price_ET_dialog = dialog.findViewById(R.id.Movie_Price_ET_dialog);
        Button cancelButton = dialog.findViewById(R.id.cancelButton);
        Button editButton = dialog.findViewById(R.id.editButton);
        dialog.show();
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Movie_Title_txt = Movie_Title_ET_dialog.getText().toString();
                String Movie_Rating_txt = Movie_Rating_ET_dialog.getText().toString();
                String Movie_Genre_txt = Movie_Genre_ET_dialog.getText().toString();
                String Movie_Year_txt = Movie_Year_ET_dialog.getText().toString();
                String Movie_Price_txt= Movie_Price_ET_dialog.getText().toString();
                if(Movie_Title_txt.equals("")) Movie_Title_ET_dialog.setError("Please Enter The Title");
                else if(Movie_Rating_txt.equals("")) Movie_Rating_ET_dialog.setError("Please Enter The Rating");
                else if(Movie_Genre_txt.equals("")) Movie_Genre_ET_dialog.setError("Please Enter The Genre");
                else if(Movie_Year_txt.equals("")) Movie_Year_ET_dialog.setError("Please Enter The Year");
                else if(Movie_Price_txt.equals("")) Movie_Price_ET_dialog.setError("Please Enter The Price");
                else
                    {
                        MovieDatabase db = new MovieDatabase(EditMovieActivity.this);
                        db.updateMovie(new Movie(Movie_Title_txt,Movie_Rating_txt,Movie_Genre_txt,
                                Movie_Year_txt,Movie_Price_txt),movie.getTitle());
                        dialog.dismiss();
                        Intent intent = new Intent(EditMovieActivity.this,EditMovieActivity.class);
                        startActivity(intent);
                        finish();
                    }

            }
        });
    }

    @Override
    public void onDeleteClick(Movie movie) {
        MovieDatabase db = new MovieDatabase(EditMovieActivity.this);
        db.deleteMovie(movie.getTitle());
        Intent intent = new Intent(EditMovieActivity.this,EditMovieActivity.class);
        startActivity(intent);
        finish();
    }
}