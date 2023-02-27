package com.mohassaan.databaseproject.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.mohassaan.databaseproject.Adapters.allMoviesAdapter;
import com.mohassaan.databaseproject.Database.MovieDatabase;
import com.mohassaan.databaseproject.Model.Movie;
import com.mohassaan.databaseproject.R;

public class romanceActivity extends AppCompatActivity implements allMoviesAdapter.onClick{

    private RecyclerView recyclerView;
    public Intent intent ;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_romance);
        intent= getIntent();
        email=intent.getStringExtra("email");

        recyclerView = findViewById(R.id.rv_romance);

        MovieDatabase db = new MovieDatabase(this);


        allMoviesAdapter myAdapter = new allMoviesAdapter(this,db.getMovieByGenre("Romance"), this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onBuyButtonClick(Movie movie) {
        Intent intent = new Intent(romanceActivity.this, PaymentActivity.class);
        intent.putExtra("MovieTitle",movie.getTitle());
        intent.putExtra("MoviePrice",movie.getPrice());
        intent.putExtra("email",email);
        startActivity(intent);
    }
}