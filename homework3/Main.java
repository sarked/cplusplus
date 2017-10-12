package javaproject2;

public class Main {
	public static void main(String[] args) {
//домашка 4
		Task task1 = new Task ("Do homework", "till friday");
		task1.getInfo();
		task1.getExp();
	System.out.println(" ");
		Recurring rec1= new Recurring ("Go shopping","on monday","week");
		rec1.getInfo();
		rec1.getExp();
	System.out.println(" ");
		Timeless dream1=new Timeless ("buy a house");
		dream1.getInfo();
		dream1.getExp();
	System.out.println(" ");
		Reminder note1=new Reminder ("buy a soap");
		note1.getInfo();
		
	}
}
