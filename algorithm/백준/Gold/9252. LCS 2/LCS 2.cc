#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
using namespace std;

int dp[1001][1001];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    string s1, s2;
    cin >> s1 >> s2;

    for(int i=0; i<=1000; ++i) {
        fill(dp[i], dp[i]+1001, 0);
    }

    for(int i=1; i<=s1.size(); ++i) {
        for(int j=1; j<=s2.size(); ++j) {
            if(s1[i-1] == s2[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
            else dp[i][j] = max(dp[i][j-1], dp[i-1][j]);
        }
    }

    stack<char> st;
    int i = s1.size();
    int j = s2.size();
    while(i!=0 && j!=0) {
        if(dp[i][j] == dp[i-1][j]) i--;
        else if(dp[i][j] == dp[i][j-1]) j--;
        else if(dp[i][j] == (dp[i-1][j-1]+1)) {
            i--; j--;
            st.push(s1[i]);
        }
    }
    
    cout << dp[s1.size()][s2.size()] << '\n';
    while(!st.empty()) {
        cout << st.top();
        st.pop();
    }

    return 0;
}