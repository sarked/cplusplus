package com.example.sarked.alphabattle;

public abstract class Spell {
    String name;
    int power;

    int type = 0;
    public static final int TYPE_SELF = 1;

    public Spell(String n,int pw) {
        name=n;
        power=pw;
    }
    abstract void cast(String crtName,Creature c);
    //принимает существо и выполняет над ним какое-то действие
}
