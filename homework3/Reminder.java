package javaproject2;

public class Reminder extends Note {
	public Reminder (String what) {
		super(what);
}
	
	@Override
	public void getInfo() {
		System.out.println("Do not forget "+what);
		
	}

}
