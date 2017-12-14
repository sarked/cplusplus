package com.example.sarked.alphabattle;

abstract public class Weapon {
    String name;
    int hit;
    int critChance;

    public Weapon (String n, int h, int cc) {
        name=n;
        hit=h;
        critChance=cc;
    }

    abstract public int getAttackpower();
    //расчет крита
}
