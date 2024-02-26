//#1463 1로 만들기 -> Dp
#include <iostream>
#include <algorithm>

#define MAX 1000001
#define INF 987654321

using namespace std;

int dp[MAX];

int count(int N);

int main()
{
	fill(dp, dp + MAX, -1);

	int N;
	cin >> N;
	cout << count(N) << '\n';

	return 0;
}

int count(int N)
{
	int& ret = dp[N];

	if (ret != -1) return ret;
	
	//기저사례
	if (N == 1) return ret = 0;

	int f1 = INF, f2 = INF, f3;
	if (N % 3 == 0) f1 = count(N / 3);
	if (N % 2 == 0) f2 = count(N / 2);
	f3 = count(N - 1);

	return ret = min({ f1, f2, f3 }) + 1;
}