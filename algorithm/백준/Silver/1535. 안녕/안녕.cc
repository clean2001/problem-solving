#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int L[21];
int J[21];
int dpa[21][101];

int DP(int N) {
    int ans = 0;

    for(int i=0; i<21; ++i) 
        fill(dpa[i], dpa[i]+101, 0);
    
    for(int i=1; i<=N; ++i) {
        for(int d=0; d<100; ++d) {
            //if(d-L[i] < 0) continue;
            if(d-L[i] >= 0)
                dpa[i][d] = max(dpa[i-1][d], dpa[i-1][d-L[i]] + J[i]);
            else
                dpa[i][d] = dpa[i-1][d];
            
            if(ans < dpa[i][d]) ans = dpa[i][d];
        }
    }

    return ans;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    for(int i=1; i<=N; ++i) {
        cin >> L[i];
    }
    for(int i=1; i<=N; ++i) {
        cin >> J[i];
    }

    int ans = DP(N);
    cout << ans << '\n';

    return 0;
}