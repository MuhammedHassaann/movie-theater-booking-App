package com.mohassaan.databaseproject.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.mohassaan.databaseproject.Database.MovieDatabase;
import com.mohassaan.databaseproject.R;

public class UserInfoActivity extends AppCompatActivity {


    TextView name_txt,email_txt,db_name_txt,db_email_txt;
    MovieDatabase db;

    Intent intent;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        intent= getIntent();
        email=intent.getStringExtra("email");

        name_txt=findViewById(R.id.name_txt);
        email_txt=findViewById(R.id.email_txt);
        db_name_txt=findViewById(R.id.db_name_txt);
        db_email_txt=findViewById(R.id.db_email_txt);
        db = new MovieDatabase(this);
        db.getCustomerData(email);

        db_name_txt.setText(db.getCustomerData(email).get(0).getName());
        db_email_txt.setText(db.getCustomerData(email).get(0).getEmail());

    }
}