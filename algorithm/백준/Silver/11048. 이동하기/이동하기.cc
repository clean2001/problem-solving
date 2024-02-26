#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int matrix[1002][1002] = {0};
int dp[1001][1001];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int N,M;
    cin >> N >> M;

    for(int i=1; i<=N; ++i) {
        for(int j=1; j<=M; ++j) {
            cin >> matrix[i][j];
        }
    }

    int r=1, c=1;

    dp[1][1] = matrix[1][1];
    for(int r=1; r<=N; ++r) {
        for(int c=1; c<=M; ++c) {
            dp[r][c] = matrix[r][c] + max({dp[r-1][c],dp[r][c-1],dp[r-1][c-1]});
        }
    }

    cout << dp[N][M] << '\n';

    return 0;
}