package com.example.sarked.alphabattle;

public class AttackSpell extends Spell{
    public AttackSpell(String n, int pw) {
        super(n, pw);
    }

    @Override
    public void cast(String crtName, Creature c) {
        c.health=c.health-power;
        if (c.health<=0) {
            System.out.println(crtName+" применяет на "+c.name+" способность "+this.name+", нанося ему "+power+" урона! "+c.name+" УБИТ СПЕЛЛОМ!");
        c.log=c.name+" получает "+power+" урона от "+this.name+" скастованного "+crtName+"! "+c.name+" УБИТ СПЕЛЛОМ!";}
        else
        {System.out.println(crtName+" применяет на "+c.name+" способность "+this.name+", нанося ему "+power+" урона!");
            c.log=c.name+" получает "+power+" урона от "+this.name+" скастованного "+crtName+"! Выживает, но остается"+c.health+" хп!";}
    }

}
