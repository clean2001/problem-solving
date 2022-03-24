#include <iostream>
#include <vector>
using namespace std;
int main()
{
	int n;
	vector<int> dp;

	cin >> n;
	
	dp.push_back(0);
	dp.push_back(1);
	dp.push_back(2);
	for (int i = 3; i <= n; i++)
		dp.push_back((dp[i - 1] + dp[i - 2]) % 10007);

	cout << dp[n] << endl;

	return 0;
}