#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
using namespace std;

const int INF = 1e9;

int dp[100001];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    fill(dp, dp+100001, INF);

    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2; dp[3] = 3;
    for(int i=4; i<=N; ++i) {
        int n = sqrt(i);
        if(n*n == i) {
            dp[i] = 1; continue;
        }

        for(int j=2; j<=n; ++j) {
            dp[i] = min(dp[i-j*j]+1, dp[i]);
        }
    }
    
    cout << dp[N] << '\n';
    return 0;
}