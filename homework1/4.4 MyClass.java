import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MyClass{
//задача 4.4, вывести двоичное представление вводимого десятичного числа
	static Scanner reader= new Scanner(System.in);
	public static void main(String[] args) {
		
			int b; int q; double x=0;
			int a=reader.nextInt();
			do{
					q=a%2;
					x=x*0.1+q;
					b=a/2;
					a=b;
				}
			while (a>=1);
			String str = Double.toString(x);
			System.out.println(str.replaceAll("\\.",""));
	}

}
