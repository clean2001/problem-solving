#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

string dp[101][101];

string add_big_num(string a, string b) {
    string rslt;
    int carry = 0;
    while(!a.empty() || !b.empty() || carry) {
        if(!a.empty()) {
            carry += a.back() - '0';
            a.pop_back();
        }

        if(!b.empty()) {
            carry += b.back() - '0';
            b.pop_back();
        }

        rslt += carry % 10 + '0';
        carry /= 10;
    }

    reverse(rslt.begin(), rslt.end());

    return rslt;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;

    for(int i=0; i <=n; ++i) {
        for(int j=0; j<=m; ++j) {
            if(j == 0 ) dp[i][j] = "1";
            if(i == j) {
                dp[i][j] = "1";
                break;
            }

            dp[i][j] = add_big_num(dp[i-1][j-1], dp[i-1][j]);
        }
    }

    cout << dp[n][m] << '\n';
    
    return 0;
}