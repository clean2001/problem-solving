#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int dp[1001][1001];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    string s1, s2;
    cin >> s1 >> s2;

    for(int i=0; i<=1000; ++i) {
        dp[0][i] = 0;
        dp[i][0] = 0;
    }

    for(int i=1; i<=s1.size(); ++i) {
        for(int j=1; j<=s2.size(); ++j) {
            if(s1[i-1] == s2[j-1]) {
                dp[i][j] = dp[i-1][j-1] + 1;
            } else {
                dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
            }
        }
    }

    // for(int i=0; i<=s1.size(); ++i) {
    //     for(int j=0; j<=s2.size(); ++j) cout << dp[i][j] << ' ';
    //     cout << '\n';
    // }

    cout << dp[s1.size()][s2.size()] << '\n';
    return 0;
}