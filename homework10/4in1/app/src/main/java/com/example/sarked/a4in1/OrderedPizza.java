package com.example.sarked.a4in1;

/**
 * Created by Sarked on 07.11.2017.
 */

public class OrderedPizza {
    String name;
    String composition;
    CharSequence size;
    double price;

    public OrderedPizza (String on, String oc, CharSequence os, double op){
        name=on;
        composition=oc;
        size=os;
        price=op;
    }
}
