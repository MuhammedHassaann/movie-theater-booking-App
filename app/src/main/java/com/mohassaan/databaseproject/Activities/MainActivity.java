package com.mohassaan.databaseproject.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mohassaan.databaseproject.Database.MovieDatabase;
import com.mohassaan.databaseproject.R;

public class MainActivity extends AppCompatActivity {

    EditText email,password;
    Button login;
    ImageView loginImageView;
    TextView welcome,register;
    MovieDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email= (EditText) findViewById(R.id.loginEmail_ED);
        password= (EditText) findViewById(R.id.loginPassword_ED);
        loginImageView=findViewById(R.id.loginImageView);
        login= findViewById(R.id.login_button);
        register=findViewById(R.id.register_txt);
        welcome=findViewById(R.id.welcome_txt);
        db=new MovieDatabase(this);

        welcome.setX(2000);
        welcome.animate().translationXBy(-2000).setDuration(1000);

        loginImageView.setX(-2000);
        loginImageView.animate().translationXBy(2000).setDuration(1000);

        login.setY(2000);
        login.animate().translationYBy(-2000).setDuration(500);

        register.setY(2500);
        register.animate().translationYBy(-2500).setDuration(750);

        email.setX(-2000);
        email.animate().translationXBy(2000).setDuration(500);

        password.setX(2000);
        password.animate().translationXBy(-2000).setDuration(500);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailString = email.getText().toString();
                String passwordString = password.getText().toString();
                if (emailString.equals(""))
                    {
                        email.setError("Please Enter Your Email");
                    }
                else if (passwordString.equals(""))
                    {
                        password.setError("Please Enter Your Password");
                    }
                else if (emailString.equals("admin")&&passwordString.equals("admin"))
                    {
                        Intent intent = new Intent(MainActivity.this, AdminActivity.class);
                        startActivity(intent);
                    }
                else
                    {
                        Boolean checkEmailPassword=db.checkEmailPassword(emailString,passwordString);
                        if(checkEmailPassword==true)
                            {
                                Toast.makeText(MainActivity.this, "Logged In", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this,userMainActivity.class);
                                intent.putExtra("email",emailString);
                                startActivity(intent);
                                finish();
                            }
                        else
                            {
                                Toast.makeText(MainActivity.this, "Wrong Email Or Password", Toast.LENGTH_LONG).show();
                            }
                    }
            }
        });
    }
}