package javaproject2;

public class Timeless extends Note implements Exp{
	public Timeless (String what) {
		super(what);
}

	@Override
	public void getInfo() {
		System.out.println("Some day or other you need to "+what);
		
	}
	@Override
	public void getExp() {
		System.out.println("Legendary!");
	}
}
