package com.example.sarked.alphabattle;

abstract public class Creature {
    String name;
    double health;
    double attackParam;
    double defParam;
    Weapon weapon;
    Spell spell;
    String log="";
    public Creature(String n, double hp, double ap, double dp, Weapon wp, Spell sp) {
        name=n;
        health=hp;
        attackParam=ap;
        defParam=dp;
        weapon=wp;
        spell=sp;

    }

    public void creatureInfo() {
        System.out.println(name+" "+health+" hp, "+attackParam+" ap,"+defParam+" dp, "+weapon.name+", "+spell.name);
    }

    abstract public void attack(Creature a);

    abstract public void magic(Creature a);

}
