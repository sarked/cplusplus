#include <cstdlib>
#include <iostream>
using namespace std;
int main (){
//вывести K-ое число Фиббоначчи. Число К вводится с клавиатуры
int y; int x; int a; int b; int c;
cin>>y; x=1; a=0; b=1;
//вводим какое по счету число фибоначчи нас интересует - y
//x-текущий цикл
while (x<y)
//выводим сам ряд
{cout<<a;cout<<" ";
c=a+b;
a=b;b=c;
x=x+1;
}
cout<<"Chislo: ";cout<<a;
}
