package javaproject3;

public class Human extends Creature{

	public Human(String n, double hp, double ap, double dp, Weapon wp, Spell sp) {
		super (n, hp, ap, dp, wp, sp);
	}

	@Override
	public void attack(Creature a) {
		double attackDamage= this.weapon.getAttackpower()+(this.weapon.hit*this.attackParam/100);
		double x=Math.round(attackDamage-((this.weapon.hit+(this.weapon.hit*this.attackParam/100))*a.defParam/100));
		a.health=Math.round(a.health-x);
		if (a.health<=0) {
			System.out.println(this.name+" ����� ���� "+weapon.name+" � ������� "+x+" ����� �� "+a.name+". "+a.name+" ����!");
			}
			else
			{System.out.println(this.name+" ����� ���� "+weapon.name+" � ������� "+x+" ����� �� "+a.name+" �������� ��� "+a.health+ " ��!");}
	}
	public void magic(Creature b) {
		this.spell.cast(this.name,b);
	}
}
