package javaproject2;

public class Task extends Note implements Exp{

		String when;
		//������ ���� ��� ������� ����� ���� �� 7 ���� ������?
	public Task (String what, String wn) {
		super(what);
		when=wn;
	}
	
	@Override
	public void getInfo() {
		System.out.println("You need to "+what+" "+when);
	}
	public void getExp() {
		System.out.println("level up!");
	}

}
