//#1629 곱셈. 분할정복 연습
#include <iostream>
using namespace std;

long long mul(long long A, long long B, long long C)
{
	if (B == 0) //기저사례
		return 1;
	else if (B % 2 == 0)
		return (mul(A, B / 2, C) * mul(A, B / 2, C)) % C;
	else
		return (A * mul(A, B - 1, C)) % C;
}
int main(void)
{
	long long A, B, C;
	cin >> A >> B >> C;

	cout << mul(A, B, C) % C << endl;
	return 0;
}