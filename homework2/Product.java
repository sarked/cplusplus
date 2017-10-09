package javaproject1;

public class Product {
	private String name;
	private double price;
	private double mass;
	private ProductType type;
	
	Product (String n, double p, double m, ProductType t){
		name=n;
		price=p;
		mass=m;
		type=t;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public double getMass() {
		return mass;
	}
	public String getType() {
		switch(type) {
		case FOOD:
			return "Еда";
		case THING:
			return "Вешь";
		case DRINK:
			return "Напиток";
		
		default:
			return "";		
		}
	}
	public String setName(String newName) {
		name=newName;
		return name;
	}
	public double setPrice(double newPrice) {
		price=newPrice;
		return price;
	}
	public double setMass(double newMass) {
		mass=newMass;
		return mass;
	}
	public ProductType setType(ProductType newType) {
		type=newType;
		return type;
	}
	double kiloPrice() {
		double kiloPrice = 1/mass*price;
		return kiloPrice;
	}
	void print() {
		System.out.println("Product info:");
		System.out.println(name);
		System.out.println(mass);
		System.out.println(price);
		System.out.println(type);
	}
}