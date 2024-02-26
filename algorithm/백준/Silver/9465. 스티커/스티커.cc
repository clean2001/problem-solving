#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int sticker[2][100000];
int dp[2][100000];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int T;
	cin >> T;
	for(int tc = 0; tc < T; ++tc) {
		int n;
		cin >> n;

		for(int i=0; i<2; ++i) {
			for(int j=0; j<n; ++j) {
				cin >> sticker[i][j];
			}
		}

		dp[0][0] = sticker[0][0];
		dp[1][0] = sticker[1][0];
		dp[0][1] = sticker[0][1] + sticker[1][0];
		dp[1][1] = sticker[1][1] + sticker[0][0];

		for(int i=2; i<n; ++i) {
			dp[0][i] = sticker[0][i] + max(dp[1][i-1], dp[1][i-2]);
			dp[1][i] = sticker[1][i] + max(dp[0][i-1], dp[0][i-2]);
		}

		int ans = max({dp[0][n-1], dp[1][n-1]});

		cout << ans << '\n';
	}
	
	return 0;
}