#include <iostream>
using namespace std;
int main()
{
	int N, K;
	int coin[10];

	cin >> N >> K;

	for (int i = 0; i < N; i++)
		cin >> coin[i];

	int i = N-1;
	int cnt = 0;
	for(int i=N-1; i>=0; i--)
	{

		while(coin[i]<=K)
		{
			K -= coin[i];
			cnt++;
		}

		if (K == 0)
			break;
	}

	cout << cnt << endl;
	return 0;
}