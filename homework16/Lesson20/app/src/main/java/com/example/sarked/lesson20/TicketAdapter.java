package com.example.sarked.lesson20;

        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.TextView;

        import java.util.ArrayList;

public class TicketAdapter extends ArrayAdapter<Ticket> {

    private ArrayList<Ticket> list;
    public TicketAdapter(Context ctx, ArrayList<Ticket> tickets){

        super(ctx,R.layout.ticket,tickets);
        list=tickets;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.ticket,null);

        TextView a = (TextView) convertView.findViewById(R.id.aviacomp);
        TextView b = (TextView) convertView.findViewById(R.id.from_to);
        TextView c = (TextView) convertView.findViewById(R.id.depart_date);
        TextView d = (TextView) convertView.findViewById(R.id.time);
        TextView e = (TextView) convertView.findViewById(R.id.price);


        a.setText(list.get(position).aviacompany);
        b.setText(list.get(position).from+" - "+list.get(position).to);
        c.setText(list.get(position).date);
        d.setText(String.valueOf(list.get(position).flight_time));
        e.setText("$ "+list.get(position).price);
        return convertView;


    }
}