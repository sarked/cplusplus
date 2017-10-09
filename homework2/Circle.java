package javaproject1;

public class Circle {
	private double radius;
	private int xAxis;
	private int yAxis;
	
	Circle (int r, int x, int y) throws InvalidShapeParametresException{
		radius=r;
		xAxis=x;
		yAxis=y;
		if (r<=0) {
		throw new InvalidShapeParametresException("Invalid parametres");
		}
	}
	Circle (int x, int y){
		xAxis=x;
		yAxis=y;
		radius=1;
	}
	Circle (int r){
		radius=r;
		xAxis=0;
		yAxis=0;
	}
	public double getRadius() {
		return radius;
	}
	public int getXaxis() {
		return xAxis;
	}
	public int getYaxis() {
		return yAxis;
	}
	public double setRadius(int newRadius) {
		radius=newRadius;
		return radius;
	}
	public int setXaxis(int newXaxis) {
		xAxis=newXaxis;
		return xAxis;
	}
	public int setYaxis(int newYaxis) {
		yAxis=newYaxis;
		return yAxis;
	}
	void Square() {
		double sq=3.14*(radius*radius);
		System.out.println(sq);
	}
	void Length() {
		double l=3.14*2*radius;
		System.out.println(l);
	}
	//метод, принимает в себя другой круг, задать другой круг
	void otherCircle (double oRadius, int ox, int oy) {
		//растояние между центрами - квадратный корень из суммы квадратов разности координат
		double rast= Math.sqrt(Math.pow((xAxis-ox),2)+Math.pow((yAxis-oy),2));
		double sumRadius = radius+oRadius;
			if (rast<sumRadius) {
			System.out.println("Круги пересекаются");
			} else {
			System.out.println("Круги НЕ пересекаются");
			}
	}
}	