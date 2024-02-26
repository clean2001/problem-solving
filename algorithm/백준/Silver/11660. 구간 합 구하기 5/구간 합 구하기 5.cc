#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int dp[1026][1026];
//vector<pair<pair<int, int>, pair<int,int>>> v;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M;
    cin >> N >> M;

    for(int i=0; i<1026; ++i)
        fill(dp[i], dp[i]+1026, 0);

    for(int i=1; i<=N; ++i) {
        for(int j=1; j<=N; ++j) {
            int num;
            cin >> num;

            dp[i][j] = num + dp[i][j-1];
            
        }
    }

    for(int j=1; j<=N; ++j) {
        for(int i=1; i<=N; ++i) {
            dp[i][j] = dp[i][j] + dp[i-1][j];
            //cout << dp[i][j] << ' ';
        }
        //cout << '\n';
    }

    for(int i=0; i<M; ++i) {
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;

        int rslt = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];
        cout << rslt << '\n';
        
    }


    return 0;
}