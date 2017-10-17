package javaproject3;

public abstract class Spell {
	String name;
	int power;
	public Spell(String n,int pw) {
		name=n;
		power=pw;
	}
	abstract void cast(String crtName,Creature c);
	//принимает существо и выполняет над ним какое-то действие
}
