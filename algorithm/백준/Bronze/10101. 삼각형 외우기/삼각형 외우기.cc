#include <iostream>
using namespace std;
int main(void)
{
	int a1, a2, a3;

	cin >> a1 >> a2 >> a3;

	if (a1 +a2 + a3 == 180)
	{
		if (a1 == 60 && a2 == 60 && a3 == 60)
			cout<< "Equilateral"<<endl;
		else if(a1 == a2 || a2 == a3 || a1 == a3)
			cout << "Isosceles" << endl;
		else
			cout << "Scalene" << endl;

	}
	else
		cout << "Error" << endl;

	return 0;
}