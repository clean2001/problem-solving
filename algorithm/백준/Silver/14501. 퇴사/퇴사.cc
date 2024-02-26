#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int N;
    cin >> N;

    int T[17];
    int P[17];
    int dp[17];

    fill(dp, dp+17, 0);
    for(int i=1; i<=N; ++i) {
        cin >> T[i] >> P[i];
    }

    for(int i=N; i>=1; --i) {
        if(T[i]+i-1 > N) {
            dp[i] = dp[i+1];
        } else {
            dp[i] = max(dp[i+1], dp[T[i]+i] + P[i]);
        }
    }
    
    int ans = 0;

    cout << dp[1] << '\n';
    return 0;
}