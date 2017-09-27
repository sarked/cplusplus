#include <cstdlib>
#include <iostream>
#include <cmath>
using namespace std;
int main (){
//вычислить корни квадратного уравнения ax^2+bx+c=0, a,b и c вводятся вручную
int a;
cin>>a;
int b;
cin>>b;
int c;
cin>>c;
int d;
d=b*b-4*a*c;
cout<<"Diskriminant raven: ";
cout<<d;
//мы нашли дискриминант, уииии
if(d<0){
	cout<<", korney net";
}
if(d==0){
	int x;
	x=-(b/(2*a));
	cout<<" x=";
	cout<<x;}
if (d>0){
	float e;
	e=sqrt(d);
	cout<<e;
	//почему-то не выводится, ну и хер с ним
	int x;
	x=(-b+e)/2*a;
	int y;
	y=(-b-e)/2*a;
	cout<<" x1=";
	cout<<x;
	cout<<" x2=";
	cout<<y;
	
}
}

