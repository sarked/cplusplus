#include <cstdlib>
#include <iostream>
using namespace std;
int main (){
//������ ��� ����� � ���� �������������� ��������
int a;int b;int x; char c;
cout<<"a=";cin>>a;
cout<<"b=";cin>>b; cin>>c;
if (c=='*'){
		x=a*b;
		cout<<"a*b=";cout<<x;}
if (c=='-'){
		x=a-b;
		cout<<"a-b=";cout<<x;}
if (c=='/'){
		x=a/b;
		cout<<"a/b=";cout<<x;}
if (c=='%'){
		x=a%b;
		cout<<"a%b=";cout<<x;}
if (c=='+'){
		x=a+b;
		cout<<"a+b=";cout<<x;}
}
