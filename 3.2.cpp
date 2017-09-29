#include <cstdlib>
#include <iostream>
using namespace std;

int main (){
//переводим вводимые секунды в дни-часы-минуты-секунды
unsigned int a;
cin>>a;
int d;
d=a/86400;
int c;
a=a-d*86400;
c=a/3600;
int m;
a=a-c*3600;
m=a/60;
a=a-m*60;
cout<<d;cout<<" Dnya, ";cout<<c;cout<<" Chasa, ";cout<<m; cout<<" Min, ";cout<<a;cout<<" Sec, ";
}
