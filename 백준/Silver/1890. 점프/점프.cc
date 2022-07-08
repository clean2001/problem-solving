#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

typedef long long ll;

int board[102][102];
ll dp[102][102];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    for(int i=1; i<=N; ++i) {
        for(int j=1; j<=N; ++j) {
            dp[i][j] = 0;
        }
    }

    for(int i=1; i<=N; ++i) {
        for(int j=1; j<=N; ++j) {
            cin >> board[i][j];
        }
    }

    dp[1][1] = 1;
    for(int i=1; i<=N; ++i) {
        for(int j=1; j<=N; ++j) {
            if(board[i][j] == 0) continue;
            int k = board[i][j];
            if(i+k <= N) dp[i+k][j] += dp[i][j];
            if(j+k <= N) dp[i][j+k] += dp[i][j];
        }
    }

    cout << dp[N][N] << '\n';
    return 0;
}