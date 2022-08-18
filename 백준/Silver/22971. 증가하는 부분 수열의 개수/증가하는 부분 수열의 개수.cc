#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;
    
    vector<int> v;
    for(int i=0; i<N; ++i) {
        int tmp;
        cin >> tmp;
        v.push_back(tmp);
    }

    int dp[5001];
    fill(dp, dp+5001, 1);

    for(int i=0; i<N; ++i) {
        for(int j=0; j<i; ++j) {
            if(v[j] < v[i]) {
                dp[i] += dp[j];
                dp[i] %= 998244353;
            }
        }
    }

    for(int i=0; i<N; ++i) {
        cout << dp[i]%998244353 << ' ';
    }

    cout << '\n';
    
    return 0;
}