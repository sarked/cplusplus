import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
//������� ��� ���� �������� ����� ��� ������ ��������� �������
public class MyClass {
static Scanner reader= new Scanner(System.in);
	public static void main(String[] args) {
		int a=reader.nextInt(); 
		int b=reader.nextInt(); 
		
		while (a!=b) {
			if (a>b) {
				a=a-b;
			}
			if (b>a){
				b=b-a;
			}
		}
		System.out.println(a);
	}
}