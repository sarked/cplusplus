package com.example.sarked.alphabattle;

import android.widget.Toast;

public class Human extends Creature{

    public Human(String n, double hp, double ap, double dp, Weapon wp, Spell sp) {
        super (n, hp, ap, dp, wp, sp);
    }

    @Override
    //public void attack(Creature a) {
    public void attack(Creature a) {
        double attackDamage= this.weapon.getAttackpower()+(this.weapon.hit*this.attackParam/100);
        double x=Math.round(attackDamage-((this.weapon.hit+(this.weapon.hit*this.attackParam/100))*a.defParam/100));
        a.health=Math.round(a.health-x);
        if (a.health<=0) {
            System.out.println(this.name+" берет свой "+weapon.name+" и наносит "+x+" урона по "+a.name+". "+a.name+" УБИТ!");
            log=this.name+" берет свой "+weapon.name+" и наносит "+x+" урона по "+a.name+". "+a.name+" УБИТ!";
        }
        else
        {
             System.out.println(this.name+" берет свой "+weapon.name+" и наносит "+x+" урона по "+a.name+" оставляя ему "+a.health+ " хп!");
            log=this.name+" берет свой "+weapon.name+" и наносит "+x+" урона по "+a.name+" оставляя ему "+a.health+ " хп!";
            }
    }
    public void magic(Creature b) {
        this.spell.cast(this.name,b);
    }
}
