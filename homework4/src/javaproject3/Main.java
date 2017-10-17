package javaproject3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		//задать оружие
		MeleeWeapon sword = new MeleeWeapon ("sword",20, 7);
		MeleeWeapon mace = new MeleeWeapon ("mace",30, 4);
		MeleeWeapon knife = new MeleeWeapon ("knife",25, 10);
		RangeWeapon bow = new RangeWeapon ("bow",27, 9);
		RangeWeapon wand = new RangeWeapon ("wand",15, 20);
		//и спеллы
		AttackSpell fireball = new AttackSpell("fireball",20);
		AttackSpell corrupt = new AttackSpell("corruption",35);
		AttackSpell grenade = new AttackSpell("grenade",15);
		AttackSpell clap = new AttackSpell("clap",30);
		DefSpell rest = new DefSpell("restoration",10);
		DefSpell shield = new DefSpell("magic shield",15);

		//коллекция людей
		ArrayList<Human>humans = new ArrayList <>();
		humans.add(new Human ("Paladin", 90, 30, 2, mace, shield));
		humans.add(new Human ("Knigth", 100, 40, 1, sword, grenade));
		humans.add(new Human ("Priest", 60, 15, 5, knife, rest));
		humans.add(new Human ("Archer", 60, 25, 5, bow, grenade));
		humans.add(new Human ("Mage", 60, 20, 5, wand, fireball));
		//коллекция монстров
		ArrayList<Monster>monsters = new ArrayList <>();
		monsters.add(new Monster ("Witch", 90, 30, 2, wand, corrupt));
		monsters.add(new Monster ("Troll", 120, 40, 1, mace, shield));
		monsters.add(new Monster ("Necromancer", 60, 20, 5, sword, clap));
		monsters.add(new Monster ("Werwolf", 80, 25, 5, knife, shield));
		monsters.add(new Monster ("Skeleton", 60, 20, 7, bow, grenade));
		
		Random randomEnemy = new Random();
		Random randomAlly = new Random();
		
		Thread t1=new Thread (new Runnable () {
			public void run() {
				int en;
				int al;
				try {
		//поихалi
			while(monsters.size()!=0||humans.size()!=0) {
				for (Human h:humans) {
					en=randomEnemy.nextInt(monsters.size());
					h.attack(monsters.get(en));
					if (monsters.get(en).health<=0) {
						monsters.remove(en);
					}
					if (monsters.size()==0) {
						System.out.println("	В команде монстров не осталось существ. Выиграла команда людей!");
						System.exit(0); 
					}
					Thread.sleep(1000);
					//определяем тип спелла и применяем
					if(h.spell instanceof DefSpell) {
						al=randomAlly.nextInt(humans.size());
						h.magic(humans.get(al));
					} else {
					en=randomEnemy.nextInt(monsters.size());
					h.magic(monsters.get(en));
						if (monsters.get(en).health<=0) {
							monsters.remove(en);
							if (monsters.size()==0) {
								System.out.println("	В команде монстров не осталось существ. Выиграла команда людей!");
								System.exit(0); 
							}
						}
					}
					Thread.sleep(1500);
				}
				
				for (Monster m:monsters) {
					en=randomEnemy.nextInt(humans.size());
					m.attack(humans.get(en));
					if (humans.get(en).health<=0) {
						humans.remove(en);
					}
					if (humans.size()==0) {
						System.out.println("	В команде людей не осталось существ. Выиграла команда монстров!");
						System.exit(0); 
					}
					Thread.sleep(1000);
					//определяем тип спелла и применяем
					if(m.spell instanceof DefSpell) {
						al=randomAlly.nextInt(monsters.size());
						m.magic(monsters.get(al));
					} else {
					en=randomEnemy.nextInt(humans.size());
					m.magic(humans.get(en));
						if (humans.get(en).health<=0) {
							humans.remove(en);
							if (humans.size()==0) {
								System.out.println("	В команде людей не осталось существ. Выиграла команда монстров!");
								System.exit(0); 
							}
						}
					}
					Thread.sleep(1500);
				}
			}
			} catch (Exception e) {}
		//конец вакханалии
			}
		});
		
		Scanner in = new Scanner(System.in);
		Thread t2=new Thread (new Runnable () {
			public void run() {
			//добавить в 1 или 2 команду существо
				while(monsters.size()!=0||humans.size()!=0) {
					int input=in.nextInt();
					if (input==1) {
						humans.add(new Human ("Paladin", 90, 30, 2, mace, shield));
						System.out.println("	(в команду ЛЮДЕЙ пришло подкрепление)");
					}else {
						monsters.add(new Monster ("Troll", 120, 40, 1, mace, shield));
						System.out.println("	(в команду МОНСТРОВ пришло подкрепление)");
					}
				}
			}
		});
		
		t1.start();
		t2.start();
		
	}
}
