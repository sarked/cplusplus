package javaproject3;

public class AttackSpell extends Spell{
	public AttackSpell(String n, int pw) {
		super(n, pw);
	}

	@Override
	public void cast(String crtName, Creature c) {
		c.health=c.health-power;
		if (c.health<=0) {
		System.out.println(crtName+" ��������� �� "+c.name+" ����������� "+this.name+", ������ ��� "+power+" �����! "+c.name+" ���� �������!");}
		else
		{System.out.println(crtName+" ��������� �� "+c.name+" ����������� "+this.name+", ������ ��� "+power+" �����!");}
	}

}
