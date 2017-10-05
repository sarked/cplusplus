#include <cstdlib>
#include <iostream>
using namespace std;
int main (){
//ввести два числа и знак арифметической операции
int a;int b;int x; char c;

cout<<"a=";cin>>a;
cout<<"b=";cin>>b; cin>>c;
switch(c){
	case '*':
		x=a*b;
		cout<<"a*b=";cout<<x;
		break;
	case '-':
		x=a-b;
		cout<<"a-b=";cout<<x;
		break;
	case '/':
		x=a/b;
		cout<<"a/b=";cout<<x;
		break;
	case '%':
		x=a%b;
		cout<<"a%b=";cout<<x;
		break;
	case '+':
		x=a+b;
		cout<<"a+b=";cout<<x;
		break;
	default:
		cout<<" wrong choice!";
	}
}
