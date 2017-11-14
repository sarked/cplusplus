package com.example.sarked.bank;

import android.support.annotation.NonNull;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class Bank implements Comparable{
    String name;

    public Bank(String n) {
        name = n;
    }
    //словарь с курсом

    Map<String, Double> dict = new HashMap<String, Double>();

    //метод для установки текущего курса в банке
    void setCourse(double ba, double ca, double ab, double cb, double ac, double bc) {
        dict.put("BA", ba);
        dict.put("CA", ca);
        dict.put("AB", ab);
        dict.put("CB", cb);
        dict.put("AC", ac);
        dict.put("BC", bc);
    }

    String show() {
        String a = String.valueOf("в " + name + "е вы получите " + dict.get("AC") + " рублей");
        return a;
    }

    double getCourse(double q, String XZ) {
        double b=1;
        switch (XZ) {
            case "BA":
                b = q * dict.get("BA");
                break;
            case "CA":
                b = q * dict.get("CA");
                break;
            case "AB":
                b = q * dict.get("AB");
                break;
            case "CB":
                b = q * dict.get("CB");
                break;
            case "AC":
                b = q * dict.get("AC");
                break;
            case "BC":
                b = q * dict.get("BC");
                break;
        }
        return b;
    }
    double getSort(String GS){
        double b=1;
        switch (GS) {
            case "BA":
                b = dict.get("BA");
                break;
            case "CA":
                b = dict.get("CA");
                break;
            case "AB":
                b = dict.get("AB");
                break;
            case "CB":
                b = dict.get("CB");
                break;
            case "AC":
                b = dict.get("AC");
                break;
            case "BC":
                b = dict.get("BC");
                break;
        }
        return b;
    }

//    public int compareTo(Bank bnk) {
//        //давайте будем сортировать объекты Employee по значению поля id от меньшего к большему
//        //будем возвращать отрицательное число, 0 или положительное число по каждому сравнению объектов
//        // здесь мы просто отнимаем значение поля одного объекта от значения поля другого объекта
//        // в результате получим 1 из 3 вариантов описанных выше вариантов
//        Double d=((this.dict.get("BA") - bnk.dict.get("BA")) *100);
//        int i = d.intValue();
//        return i;
//    }

    @Override
    public int compareTo(@NonNull Object o) {
        return 0;
    }
}