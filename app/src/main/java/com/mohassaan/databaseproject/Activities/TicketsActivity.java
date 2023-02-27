package com.mohassaan.databaseproject.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.mohassaan.databaseproject.Adapters.TicketsAdapter;
import com.mohassaan.databaseproject.Adapters.allMoviesAdapter;
import com.mohassaan.databaseproject.Database.MovieDatabase;
import com.mohassaan.databaseproject.Model.Movie;
import com.mohassaan.databaseproject.Model.Ticket;
import com.mohassaan.databaseproject.R;

import java.util.ArrayList;

public class TicketsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    MovieDatabase db;
    Intent intent;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);

        intent= getIntent();
        email=intent.getStringExtra("email");

        recyclerView=findViewById(R.id.rv_tickets);



        db = new MovieDatabase(this);
        TicketsAdapter myAdapter = new TicketsAdapter(this,db.getTicket(email));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myAdapter);
    }
}