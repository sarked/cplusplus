#include <cstdlib>
#include <iostream>
using namespace std;
int main (){
	//высичлить процент А% от исла Х, А и Х вводятся вручную
	float x;
	cout <<"Vvodim chislo:";
	cin>> x;
	float a;
	cout <<"Skolko procentov vichislit?:";
	cin>> a;
	float b;
	b=x/100*a;
	cout <<b;
}
