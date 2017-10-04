import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
//вывести введенное число в отформатированном виде - по три разряда (1 234 567 890)
public class MyClass {
static Scanner reader= new Scanner(System.in);
	public static void main(String[] args) {
		String str1=""; String str2=""; String c; int b; int a;
		int n=reader.nextInt(); 

			while (n>999) {
				b=n%1000;	
				n=(n-b)/1000;
				c= String.valueOf(b);
				str2=" "+c+str1;
				str1=str2;
			}
		String d= String.valueOf(n);
		str2=n+str2;
		System.out.println(str2);
	}
}