import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
//для введенного числа N вывести сумму всех его натуральных делителей
public class MyClass {
static Scanner reader= new Scanner(System.in);
	public static void main(String[] args) {
		int n=reader.nextInt(); 
		int c; int sum=0;

			for (int a=1; a<=n; a+=1) {
				c=n%a;
				if (c==0){
					sum=sum+a;
					System.out.println(a);
				};
		}
		System.out.println(sum);
	}
}