package com.example.sarked.alphabattle;

public class DefSpell extends Spell{

    public DefSpell(String n, int pw) {
        super(n, pw);
    }

    @Override
    public void cast(String crtName, Creature c) {
        c.health=c.health+power;
        System.out.println(crtName+" применяет на "+c.name+" способность "+this.name+", исцеляя ему "+power+" хп!");
        c.log=crtName+" применяет на "+c.name+" "+this.name+" и получает исцеление в размере"+power+" хп!";
    }

}
