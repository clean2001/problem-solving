#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    int prev_col;
    vector<int> max_dp(3,0);
    vector<int> min_dp(3,0);
    vector<int> min_next(3);
    vector<int> max_next(3);

    cin >> N;

    for(int i=1; i<=N; ++i) {

        int left, mid, right;
        cin >> left >> mid >> right;
        
        max_next = {
            left + max(max_dp[0], max_dp[1]),
            mid + max({max_dp[0], max_dp[1], max_dp[2]}),
            right + max(max_dp[1], max_dp[2])

        };

        min_next = {
            left + min(min_dp[0], min_dp[1]),
            mid + min({min_dp[0], min_dp[1], min_dp[2]}),
            right + min(min_dp[1], min_dp[2])
        };

        swap(min_dp, min_next);
        swap(max_dp, max_next);
    }

    cout << max({max_dp[0], max_dp[1], max_dp[2]}) << ' ';
    cout << min({min_dp[0], min_dp[1], min_dp[2]}) << '\n';

    return 0;
}