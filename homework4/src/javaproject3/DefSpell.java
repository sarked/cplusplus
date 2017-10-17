package javaproject3;

public class DefSpell extends Spell{
	public DefSpell(String n, int pw) {
		super(n, pw);
	}

	@Override
	public void cast(String crtName, Creature c) {
		c.health=c.health+power;
		System.out.println(crtName+" примен€ет на "+c.name+" способность "+this.name+", исцел€€ ему "+power+" хп!");
	}

}
