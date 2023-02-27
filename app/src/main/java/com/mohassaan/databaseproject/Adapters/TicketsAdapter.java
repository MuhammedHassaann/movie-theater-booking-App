package com.mohassaan.databaseproject.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mohassaan.databaseproject.Model.Customer;
import com.mohassaan.databaseproject.Model.Ticket;
import com.mohassaan.databaseproject.R;

import java.util.List;
import java.util.Random;

public class TicketsAdapter extends RecyclerView.Adapter<TicketViewHolder>{

    private Context context;
    private List<Customer> customers;

    public TicketsAdapter(Context context, List<Customer> customers) {
        this.context = context;
        this.customers = customers;
    }

    @NonNull
    @Override
    public TicketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View myView = inflater.inflate(R.layout.root_ticket,parent,false);
        return new TicketViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull TicketViewHolder holder, int position) {
        Customer customer = customers.get(position);

        String randChar = String.valueOf(getCharString());
        String randInt = String.valueOf(getRandomNumber(1,45));
        String time = String.valueOf(getRandomNumber(1,12))+"PM";

        holder.ticket_title_txt.setText(customer.getMovie_title());
        holder.ticket_price_txt.setText(customer.getMovie_price());
        holder.ticket_customerName_txt.setText(customer.getName());
        holder.ticket_seat_txt.setText(randInt+randChar);
        holder.ticket_time_txt.setText(time);
    }


    @Override
    public int getItemCount() {
        return customers.size();
    }


    static char getCharString()
    {

        Random random = new Random();

        char randomizedCharacter = (char) (random.nextInt(5) + 'A');
        return randomizedCharacter;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
