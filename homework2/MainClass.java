package javaproject1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainClass {
	public static void main(String[] args) {
		//круги
		Circle Circle1 = null;
		try {	
			Circle1 = new Circle (2,3,1);
		}catch (InvalidShapeParametresException e)	{
			System.out.println(e.getMessage());
		}

		System.out.println(Circle1.getRadius());
		System.out.println(Circle1.getXaxis());
		System.out.println(Circle1.getYaxis());
		
		Circle1.Square();
		Circle1.Length();
		Circle1.otherCircle(2,3,4);
		
		//треугольник
		Triangle Triangle1 = null;
		try {
			Triangle1 = new Triangle (1, 8, -2, -7, -4, -17);
		}catch(InvalidShapeParametresException e) {
			System.out.println(e.getMessage());
		}
		
		Triangle Triangle2 = null;
		try {
			Triangle2 = new Triangle (3, 2, 3, 4, 6, 7);
		}catch(InvalidShapeParametresException e) {
			System.out.println(e.getMessage());
		}
		Triangle2.Perimetr();
		Triangle2.Square();
		
		//товар
		Product Product1 = new Product ("Пельмени", 5, 0.5,ProductType.FOOD);
	//	System.out.println(Product1.getType());
	//	System.out.println(Product1.kiloPrice());
	//	Product1.print();
		
/*
		System.out.println(myMachine.getType());
		try {
		myMachine.beep(-3);
		} catch (NegativeNumberException e) {
		System.out.println(e.getMessage());
		}*/
	}
}
