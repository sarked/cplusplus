#include <cstdlib>
#include <iostream>
using namespace std;
int main (){
//найти максимальное из 4-ех введенных чисел
int a;
cin>>a;
int b;
cin>>b;
int c;
cin>>c;
int d;
cin>>d;
int x;
	if (a>=b){
		x=a;
	}else{
		x=b;
	}
	if (c>=x){
		x=c;
	}else{
		x=x;
	}
	if (d>=x){
		x=d;
	}else{
		x=x;
	}
cout<<"Samoye bolshoe chislo: ";
cout<<x;
}

