#include <iostream>
using namespace std;
int main()
{
	int N;
	int cnt = 0;

	cin >> N;
	while (N >= 3)
	{
		if (N % 5 == 0)
		{
			cnt += N / 5;
			cout << cnt << endl;
			return 0;
		}
		else
		{
			N -= 3;
			cnt++;
		}
	}
	
	if (N != 0)
		cnt = -1;

	cout << cnt << endl;
	return 0;
}