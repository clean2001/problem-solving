#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int v[101];
int w[101];
int dpa[101][100001];

int DP(int N, int K) {
    int ans = 0;

    for(int i=0; i<=N; ++i)
        fill(dpa[i], dpa[i]+K, 0);

    for(int i=1; i<=N; ++i) {
        for(int j=0; j<=K; ++j) {
            if(j + w[i] <= K)
                dpa[i][j] = max(dpa[i-1][j], dpa[i-1][j+w[i]] + v[i]);
            else dpa[i][j] = dpa[i-1][j];

            ans = max(ans, dpa[i][j]);
        }
    }

    return ans;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, K;
    cin >> N >> K;

    for(int i=1; i<=N; ++i) {
        cin >> w[i] >> v[i];
    }

    int ans = DP(N, K);
    cout << ans <<'\n';
    return 0;
}