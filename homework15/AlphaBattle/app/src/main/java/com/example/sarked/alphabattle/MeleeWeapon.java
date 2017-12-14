package com.example.sarked.alphabattle;
import java.util.Random;

public class MeleeWeapon extends Weapon {

    public MeleeWeapon(String n, int h, int cc) {
        super (n, h, cc);

    }

    @Override
    public int getAttackpower() {
        Random random = new Random();
        int crt=random.nextInt(99)+1;
        int hit2=hit;
        int crt2=this.critChance;
        if (crt2>crt) {
            hit2=hit*3;
            System.out.println("CRIT!");
        }
        return hit2;
    }

}
