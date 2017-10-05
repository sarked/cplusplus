#include <cstdlib>
#include <iostream>
using namespace std;
int main (){
//вы€снить, могут ли три введенных числа быть сторонами какого-нибудь треугольника
int a;int b;int c;
cin>>a;cin>>b;cin>>c;
if ((a+b>c)&&(a+c>b)&&(c+b>a)){
	cout<<"Vse OK! Treugolnik sushestvuet";
	}else{
	cout<<"Chert! Treugolnik NE sushestvuet";}
}


