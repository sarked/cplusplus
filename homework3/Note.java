package javaproject2;

abstract class Note {
	public String what;
	public Note (String what) {
		this.what=what;
	}
	
	public abstract void getInfo();

}
