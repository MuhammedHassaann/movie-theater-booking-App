package com.mohassaan.databaseproject.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mohassaan.databaseproject.R;

public class userMainActivity extends AppCompatActivity {

    CardView genres, allMovies,tickets,info;
    public Intent intent ;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
        intent= getIntent();
        email=intent.getStringExtra("email");

        //receiving email from login activity to pass it to my info activity



        genres =findViewById(R.id.categeoriesCardView);
        allMovies =findViewById(R.id.allMoviewsCardView);
        tickets=findViewById(R.id.ticketsCardView);
        info=findViewById(R.id.infoCardView);

        //Animating the activity
        genres.setX(-2000);
        tickets.setX(-2000);
        genres.animate().translationXBy(2000).setDuration(500);
        tickets.animate().translationXBy(2000).setDuration(500);

        allMovies.setX(2000);
        info.setX(2000);
        allMovies.animate().translationXBy(-2000).setDuration(500);
        info.animate().translationXBy(-2000).setDuration(500);

        //Cards clickListeners

        allMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userMainActivity.this, AllMoviesActivity.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });

        genres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userMainActivity.this, genreActivity.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(userMainActivity.this,UserInfoActivity.class);
                intent1.putExtra("email",email);
                startActivity(intent1);
            }
        });

        tickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 =new Intent(userMainActivity.this, TicketsActivity.class);
                intent1.putExtra("email",email);
                startActivity(intent1);
            }
        });


    }
}