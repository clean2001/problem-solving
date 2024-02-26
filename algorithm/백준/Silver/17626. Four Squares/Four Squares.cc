#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int cnt = 0;
//17626 Four Squares -> Dp로 풀기
//dp[i]는 i를 제곱수의 합으로 표현하는 최소 개수가 들어감
// 만약 27이 주어짐 그럼 dp[26], dp[23], dp[18], dp[11], dp[2] 중에 가장 작은게 정답?
int main()
{
	
	int n;
	int minNum;

	cin >> n;
	vector<int> dp(n+1, 0);

	dp[0] = 0; dp[1] = 1;
	for (int i = 2; i <= n; i++)
	{
		minNum = 987654321;
		for (int j = 1; j * j <= i; j++)
		{
			int tmp = i - j * j;
			minNum = min(minNum, dp[tmp] + 1);
		}

		dp[i] = minNum;
	}

	cout << dp[n] << endl;
	return 0;
}
