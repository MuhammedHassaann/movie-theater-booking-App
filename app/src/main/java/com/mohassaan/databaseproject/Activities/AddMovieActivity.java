package com.mohassaan.databaseproject.Activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.mohassaan.databaseproject.Database.MovieDatabase;
import com.mohassaan.databaseproject.Model.Movie;
import com.mohassaan.databaseproject.R;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class AddMovieActivity extends AppCompatActivity {

    public Bitmap bitmap;
    CardView cv_addMovieImage;
    ImageView image;
    EditText movieTitle_ED,movieRating_ED,movieGenre_ED,movieYear_ED,moviePrice_ED;
    Button addMovieButton;
    MovieDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);

        cv_addMovieImage=findViewById(R.id.cv_addMovieImage);
        movieTitle_ED=findViewById(R.id.movieTitle_ED);
        movieRating_ED=findViewById(R.id.movieRating_ED);
        movieGenre_ED=findViewById(R.id.movieGenre_ED);
        movieYear_ED=findViewById(R.id.movieYear_ED);
        moviePrice_ED=findViewById(R.id.moviePrice_ED);
        addMovieButton=findViewById(R.id.addMovieButton);
        image = findViewById(R.id.addimage_ImageView);
        db = new MovieDatabase(AddMovieActivity.this);
        cv_addMovieImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });



        addMovieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String movieTitle = movieTitle_ED.getText().toString();
                String movieRating= movieRating_ED.getText().toString();
                String movieGenre= movieGenre_ED.getText().toString();
                String movieYear= movieYear_ED.getText().toString();
                String moviePrice= moviePrice_ED.getText().toString();

                if(movieTitle.equals("")) movieTitle_ED.setError("Please Enter The Title");
                else if(movieRating.equals("")) movieRating_ED.setError("Please Enter The Rating");
                else if(movieGenre.equals("")) movieGenre_ED.setError("Please Enter The Genre");
                else if(movieYear.equals("")) movieYear_ED.setError("Please Enter The Year");
                else if(moviePrice.equals("")) moviePrice_ED.setError("Please Enter The Price");
                else if (bitmap==null)
                    {
                        Toast.makeText(AddMovieActivity.this, "Please Add The Movie Poster", Toast.LENGTH_SHORT).show();
                    }
                else
                    {
                        Movie movie = new Movie(movieTitle,movieRating,
                                movieGenre,movieYear,moviePrice,bitmap);
                        db.addMovie(movie);
                        Toast.makeText(AddMovieActivity.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AddMovieActivity.this,AdminActivity.class);
                        startActivity(intent);
                        finish();
                    }
            }
        });

    }

    public void openGallery ()
    {
        Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent,100);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100&&resultCode==RESULT_OK)
        {
            Uri uri=data.getData();

            try {
                InputStream inputStream=getContentResolver().openInputStream(uri);
                bitmap= BitmapFactory.decodeStream(inputStream);
                image.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                Log.e("ex",e.getMessage());
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            }
        }
    }
}