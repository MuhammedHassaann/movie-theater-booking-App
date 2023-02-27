package com.mohassaan.databaseproject.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.mohassaan.databaseproject.Database.MovieDatabase;
import com.mohassaan.databaseproject.R;

public class Register extends AppCompatActivity {

    EditText fullName,registerEmail,registerPassword,confirmRegisterPassword;
    Button register;
    ImageView imageView;
    MovieDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullName=findViewById(R.id.fullName_ED);
        registerEmail=findViewById(R.id.registerEmail_ED);
        registerPassword=findViewById(R.id.regPassword_ED);
        confirmRegisterPassword=findViewById(R.id.regPasswordConfirm_ED);
        register=findViewById(R.id.registerButton);
        imageView=findViewById(R.id.imageView);
        db= new MovieDatabase(this);

        imageView.setY(-2000);
        imageView.animate().translationYBy(2000).setDuration(1500);

        fullName.setX(-2000);
        fullName.animate().translationXBy(2000).setDuration(500);

        registerEmail.setX(2000);
        registerEmail.animate().translationXBy(-2000).setDuration(500);

        registerPassword.setX(-2000);
        registerPassword.animate().translationXBy(2000).setDuration(500);

        confirmRegisterPassword.setX(2000);
        confirmRegisterPassword.animate().translationXBy(-2000).setDuration(500);

        register.setY(2000);
        register.animate().translationYBy(-2000).setDuration(1250);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameString = fullName.getText().toString();
                String emailString = registerEmail.getText().toString();
                String passwordString = registerPassword.getText().toString();
                String confirmPasswordString = confirmRegisterPassword.getText().toString();

                if (nameString.equals(""))
                {
                    fullName.setError("Please Enter Your Full Name");
                }
                else if (emailString.equals(""))
                {
                    registerEmail.setError("Please Enter Your Email");
                }
                else if (passwordString.equals(""))
                {
                    registerPassword.setError("Please Enter Your Password");
                }
                else if (confirmPasswordString.equals(""))
                {
                    confirmRegisterPassword.setError("Please Enter Your Password");
                }
                else
                    {
                        if (passwordString.equals(confirmPasswordString))
                            {
                                boolean checkEmail = db.checkEmail(emailString);
                                if(checkEmail==false)
                                    {
                                        Boolean addCustomer = db.addCustomer(nameString,emailString,passwordString);
                                        if (addCustomer)
                                            {
                                                Toast.makeText(Register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                                Intent intent=new Intent(Register.this,MainActivity.class);
                                                startActivity(intent);
                                                finish();
                                            }
                                        else
                                            {
                                                Toast.makeText(Register.this, "Registered Failed", Toast.LENGTH_SHORT).show();
                                            }
                                    }
                                else
                                    {
                                        Toast.makeText(Register.this,"Email Already Exists",Toast.LENGTH_SHORT).show();
                                    }
                            }
                    }

            }
        });
    }
}