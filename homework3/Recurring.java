package javaproject2;

public class Recurring extends Note implements Exp{
	String when;
	String every;
	public Recurring (String what, String wn, String ev) {
		super(what);
		when=wn;
		every=ev;
	}
	@Override
	public void getInfo() {
		System.out.println("You need to "+what+" "+when+" every "+every);
	}
	@Override
	public void getExp() {
		System.out.println("Good! see you a "+every+" later!");
		
	}

}
