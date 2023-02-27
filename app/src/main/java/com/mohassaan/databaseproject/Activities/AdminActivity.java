package com.mohassaan.databaseproject.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mohassaan.databaseproject.R;

public class AdminActivity extends AppCompatActivity {

    CardView cv_addMovie,cv_editMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        cv_addMovie=findViewById(R.id.cv_addMovie);
        cv_editMovie=findViewById(R.id.cv_EditMovie);

        cv_addMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminActivity.this, AddMovieActivity.class);
                startActivity(intent);
            }
        });

        cv_editMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminActivity.this, EditMovieActivity.class);
                startActivity(intent);
            }
        });
    }
}