package com.mohassaan.databaseproject.Adapters;


import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mohassaan.databaseproject.R;

public class TicketViewHolder extends RecyclerView.ViewHolder{

    TextView ticket_title_txt,ticket_price_txt,ticket_customerName_txt,ticket_time_txt,ticket_seat_txt;

    public TicketViewHolder(@NonNull View itemView) {
        super(itemView);

        ticket_title_txt = itemView.findViewById(R.id.ticket_title_txt);
        ticket_price_txt = itemView.findViewById(R.id.ticket_price_txt);
        ticket_customerName_txt = itemView.findViewById(R.id.ticket_customerName_txt);
        ticket_time_txt = itemView.findViewById(R.id.ticket_time_txt);
        ticket_seat_txt = itemView.findViewById(R.id.ticket_seat_txt);
    }
}
