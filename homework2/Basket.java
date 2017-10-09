package javaproject1;

public class Basket {
	int productQuantity;
	Product [] Basket;
	
	Basket (int quantity){
		productQuantity = quantity;
		Basket = new Product[productQuantity];
	}
	
	void putInBasket (Product T, int k ) throws InvalidShapeParametresException {
		Basket [k-1]= T;
		if (k>productQuantity) {
			throw new InvalidShapeParametresException("place do not exist");
			}
	}
	
	void allPrice() {
		double ap=0;
			for (int i = 0; i < Basket.length; i+=1) {
				if (Basket[i]==null) {
					} else {
					ap=ap+Basket[i].getPrice();
				}
			}
			System.out.println(ap);
			}

	void printBasket() {
		System.out.println("Basket info:");
		double ap=0;
		int all=0;
		for (int i = 0; i < Basket.length; i+=1) {
			if (Basket[i]==null) {
				} else {
				ap=ap+Basket[i].getPrice();
				all+=1;
				System.out.println("Product info:");
				System.out.println(Basket[i].getName());
				System.out.println(Basket[i].getPrice());
			}
		}
		System.out.println("Summ:"); System.out.println(ap);
		System.out.println("All products:"); System.out.println(all);
	}
}