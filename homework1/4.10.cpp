#include <cstdlib>
#include <iostream>
using namespace std;
int main (){
//ввести два числа и знак арифметической операции, в конце запросить продолжение
int a;int b;int x; char c; int i=1;
	do{
	
		cout<<"a=";cin>>a;
		cout<<"b=";cin>>b; cin>>c;
		switch(c){
			case '*':
				x=a*b;
				cout<<"a*b=";cout<<x;
				i=0;
				cout<<"\n Print 1 to continue";
				cin>>i;
				break;
			case '-':
				x=a-b;
				cout<<"a-b=";cout<<x;
				i=0;
				cout<<"\n Print 1 to continue";
				cin>>i;
				break;
			case '/':
				x=a/b;
				cout<<"a/b=";cout<<x;
				i=0;
				cout<<"\n Print 1 to continue";
				cin>>i;
				break;
			case '%':
				x=a%b;
				cout<<"a%b=";cout<<x;
				i=0;
				cout<<"\n Print 1 to continue";
				cin>>i;
				break;
			case '+':
				x=a+b;
				cout<<"a+b=";cout<<x;
				i=0;
				cout<<"\n Print 1 to continue";
				cin>>i;
				break;
			default:
				cout<<" wrong choice!";
			}
	
	}
			while (i==1);
}
