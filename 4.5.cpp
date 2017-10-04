#include <cstdlib>
#include <iostream>
using namespace std;
int main (){
//определитель простых чисел
	int n; cin>>n; int a;
		for (int i=2; i<n; i+=1) {
			a=n%i;
			if (a==0) {
				cout<<"  Chislo ne prostoe";
				}
		}
cout<<"  Chislo prostoe";
}
