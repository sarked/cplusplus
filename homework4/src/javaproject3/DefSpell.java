package javaproject3;

public class DefSpell extends Spell{
	public DefSpell(String n, int pw) {
		super(n, pw);
	}

	@Override
	public void cast(String crtName, Creature c) {
		c.health=c.health+power;
		System.out.println(crtName+" ��������� �� "+c.name+" ����������� "+this.name+", ������� ��� "+power+" ��!");
	}

}
