package com.example.sarked.fragments;


import java.util.ArrayList;

public class Data {
    public static ArrayList<Article> articles= new ArrayList<>();

    //статическая инициализация, чтоб не вызывать методы. Выполнится еред выполнением
    static{
        articles.add(new Article("Пенсионерка украла бочку","В каменной горке вероломно и ночью. Ищем очевидцев. Звоните ментам."));
        articles.add(new Article("Ларек с шавухой","В уручье открылся киоск, в котором продают шаурму за 5 рублей."));
        articles.add(new Article("Совещание у Президента","Вчера состоялось совещание. Министров вызывали на ковер, половина уволена."));
        articles.add(new Article("Выставка пекинесов","В выходные пройдет выставка. Все пекинесы красивые, но очень маленькие."));
    }
}
