#include <cstdlib>
#include <iostream>
using namespace std;
int main (){
//������� K-�� ����� ����������. ����� � �������� � ����������
int y; int x; int a; int b; int c;
cin>>y; x=1; a=0; b=1;
//������ ����� �� ����� ����� ��������� ��� ���������� - y
//x-������� ����
while (x<y)
//������� ��� ���
{cout<<a;cout<<" ";
c=a+b;
a=b;b=c;
x=x+1;
}
cout<<"Chislo: ";cout<<a;
}
