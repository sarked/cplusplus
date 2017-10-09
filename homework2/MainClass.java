package javaproject1;

public class MainClass {
	public static void main(String[] args) {
		//Circle
		Circle Circle1 = null;
		try {	
			Circle1 = new Circle (2,3,1);
		}	catch (InvalidShapeParametresException e)	{
			System.out.println(e.getMessage());
			}

		System.out.println(Circle1.getRadius());
		System.out.println(Circle1.getXaxis());
		System.out.println(Circle1.getYaxis());
		
		Circle1.Square();
		Circle1.Length();
		Circle1.otherCircle(2,3,4);
		
		//Triangle
		Triangle Triangle1 = null;
		try {
			Triangle1 = new Triangle (1, 8, -2, -7, -4, -17);
		}	catch(InvalidShapeParametresException e) {
			System.out.println(e.getMessage());
			}
		
		Triangle Triangle2 = null;
		try {
			Triangle2 = new Triangle (3, 2, 3, 4, 6, 7);
		}	catch(InvalidShapeParametresException e) {
			System.out.println(e.getMessage());
			}
		Triangle2.Perimetr();
		Triangle2.Square();
		
		//Product
		Product Product1 = new Product ("Pelmeni", 5, 0.5,ProductType.FOOD);
		Product Product2 = new Product ("Milk", 6, 1,ProductType.DRINK);
		System.out.println(Product1.getType());
		System.out.println(Product1.kiloPrice());
		Product1.print();
		
		//Basket
		Basket Basket1 = new Basket (5);
		
		try {Basket1.putInBasket(Product1, 5);
		}	catch(InvalidShapeParametresException e) {
			System.out.println(e.getMessage());
			}
		try {Basket1.putInBasket(Product2, 3);
		}	catch(InvalidShapeParametresException e) {
			System.out.println(e.getMessage());
			}
		Basket1.allPrice();
		Basket1.printBasket();
	}
}
