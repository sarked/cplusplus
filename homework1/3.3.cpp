#include <cstdlib>
#include <iostream>
using namespace std;
int main (){
//��������, ����� �� ��� ��������� ����� ���� ��������� ������-������ ������������
int a;int b;int c;
cin>>a;cin>>b;cin>>c;
if ((a+b>c)&&(a+c>b)&&(c+b>a)){
	cout<<"Vse OK! Treugolnik sushestvuet";
	}else{
	cout<<"Chert! Treugolnik NE sushestvuet";}
}


