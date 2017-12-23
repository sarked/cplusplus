package com.example.sarked.lesson20;

public class Ticket {

    int id;
    String from;
    String to;
    Double price;
    String date;
    int flight_time;
    String aviacompany;


    public Ticket(int i, String f, String t, Double pr, String dt, int ft, String avc ){
        id=i;
        from=f;
        to=t;
        price=pr;
        date=dt;
        flight_time=ft;
        aviacompany=avc;
    }
}
