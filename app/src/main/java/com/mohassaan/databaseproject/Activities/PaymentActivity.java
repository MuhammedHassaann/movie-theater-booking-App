package com.mohassaan.databaseproject.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.mohassaan.databaseproject.Database.MovieDatabase;
import com.mohassaan.databaseproject.Model.Ticket;
import com.mohassaan.databaseproject.R;

public class PaymentActivity extends AppCompatActivity {

    Button Buy_Ticket_btn;
    EditText creditCardNumber_ED,CVV_ED,expireDate_ED;
    ImageView creditCard_ImageView;
    public Intent intent;
    public String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        intent= getIntent();
        email=intent.getStringExtra("email");

        String movieTitle =intent.getStringExtra("MovieTitle");
        String moviePrice =intent.getStringExtra("MoviePrice");

        creditCardNumber_ED=findViewById(R.id.creditCardNumber_ED);
        CVV_ED=findViewById(R.id.CVV_ED);
        expireDate_ED=findViewById(R.id.expireDate_ED);
        creditCard_ImageView=findViewById(R.id.creditCard_ImageView);
        Buy_Ticket_btn=findViewById(R.id.Buy_Ticket_btn);

        creditCard_ImageView.setX(-2000);
        creditCard_ImageView.animate().translationXBy(2000).rotation(1800).setDuration(1250);

        Buy_Ticket_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String creditCardNumber = creditCardNumber_ED.getText().toString();
                String CVV = CVV_ED.getText().toString();
                String expireDate = expireDate_ED.getText().toString();

                if(creditCardNumber.equals("")) creditCardNumber_ED.setError("Please Enter Credit Card Number");
                else if(CVV.equals("")) CVV_ED.setError("Please Enter CVV Number");
                else if(expireDate.equals("")) expireDate_ED.setError("Please Enter Expire Date");
                else
                    {
                        MovieDatabase db = new MovieDatabase(PaymentActivity.this);
                        db.addTicket(new Ticket(movieTitle,moviePrice),email);
                        Intent intent1 = new Intent(PaymentActivity.this, TicketsActivity.class);
                        intent1.putExtra("email",email);
                        startActivity(intent1);
                        finish();
                    }
            }
        });


    }
}