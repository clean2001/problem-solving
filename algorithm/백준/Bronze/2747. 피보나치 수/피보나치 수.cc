//top down -> 재귀
//Bottom up -> 반복분
#include <iostream>
#include <vector>
using namespace std;
int main(void)
{
	int n;

	cin >> n;

	vector<int> fibo(n+1);
	fibo[0] = 0;
	fibo[1] = 1;

	for (int i = 2; i <= n; i++)
	{
		fibo[i] = fibo[i - 1] + fibo[i - 2];
	}

	cout << fibo[n] << endl;

	return 0;
}