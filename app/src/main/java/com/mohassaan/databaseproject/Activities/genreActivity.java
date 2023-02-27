package com.mohassaan.databaseproject.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mohassaan.databaseproject.R;

public class genreActivity extends AppCompatActivity {

    CardView cv_action,cv_horror,cv_drama,cv_romance,
            cv_comedy,cv_animation,cv_fantasy,cv_scienceFiction;
    public Intent intent ;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);
        intent= getIntent();
        email=intent.getStringExtra("email");


        cv_action=findViewById(R.id.cv_action);
        cv_horror=findViewById(R.id.cv_horror);
        cv_drama=findViewById(R.id.cv_drama);
        cv_romance=findViewById(R.id.cv_romance);
        cv_comedy=findViewById(R.id.cv_comedy);
        cv_animation=findViewById(R.id.cv_animation);
        cv_fantasy=findViewById(R.id.cv_fantasy);
        cv_scienceFiction=findViewById(R.id.cv_scienceFiction);


        cv_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(genreActivity.this,actionActivity.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });

        cv_horror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(genreActivity.this,horrorActivity.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });

        cv_drama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(genreActivity.this,dramaActivity.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });

        cv_romance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(genreActivity.this,romanceActivity.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });

        cv_comedy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(genreActivity.this,comedyActivity.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });

        cv_animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(genreActivity.this,animationActivity.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });

        cv_fantasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(genreActivity.this,fantasyActivity.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });

        cv_scienceFiction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(genreActivity.this,scienceFictionActivity.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });


    }
}