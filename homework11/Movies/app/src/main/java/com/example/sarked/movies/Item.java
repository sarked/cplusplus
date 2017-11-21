package com.example.sarked.movies;

public class Item implements java.io.Serializable{
    String name;
    String descriotion;

    Item(String n, String d){
        name=n;
        descriotion=d;
    }
}
