package javaproject1;

public class Triangle {
	int ax;
	int ay;
	int bx;
	int by;
	int cx;
	int cy;
	
	Triangle (int a, int b, int c, int d, int e, int f) throws InvalidShapeParametresException{
		ax=a;
		ay=b;
		bx=c;
		by=d;
		cx=e;
		cy=f;
		
		if ((ax-cx)*(by-cy)==(bx-cx)*(ay-cy)) {throw new InvalidShapeParametresException("Invalid parametres");
		}
	}
	
	void Perimetr () {
		double ab= Math.sqrt(Math.pow((ax-bx),2)+Math.pow((ay-by),2));
		double bc= Math.sqrt(Math.pow((bx-cx),2)+Math.pow((by-cy),2));
		double ca= Math.sqrt(Math.pow((cx-ax),2)+Math.pow((cy-ay),2));
		double Per=ab+bc+ca;
		System.out.println(Per);
	}
	void Square () {
		double ab= Math.sqrt(Math.pow((ax-bx),2)+Math.pow((ay-by),2));
		double bc= Math.sqrt(Math.pow((bx-cx),2)+Math.pow((by-cy),2));
		double ca= Math.sqrt(Math.pow((cx-ax),2)+Math.pow((cy-ay),2));
		double p= (ab+bc+ca)/2;
		double S= Math.sqrt(p*(p-ab)*(p-bc)*(p-ca));
		System.out.println(S);
	}
}
