#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

typedef long long ll;

vector<pair<ll, ll>> dp(41);
bool flag[41];

void solve(int N) {
    if(flag[N] == true) return;

    solve(N-1);
    solve(N-2);
    dp[N].first = dp[N-1].first + dp[N-2].first;
    dp[N].second = dp[N-1].second + dp[N-2].second;
    flag[N] = true;
} 

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;

    dp[0] = {1, 0};
    dp[1] = {0, 1};

    fill(flag, flag+41, false);
    flag[0] = true;
    flag[1] = true;

    for(int i=0; i<T; ++i) {
        int N;
        cin >> N;

        solve(N);

        cout << dp[N].first << ' ' << dp[N].second << '\n';

    }
    
    return 0;
}