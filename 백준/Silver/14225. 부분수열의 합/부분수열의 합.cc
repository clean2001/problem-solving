#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int N;
int M;
vector<int> set;
vector<int> subset;
vector<int> sums;

void solve(int k) {
    if(k == N) {
        int sum = 0;
        for(int e : subset) sum += e;
        sums.push_back(sum);
    } else {
        subset.push_back(set[k]);
        solve(k+1);

        subset.pop_back();
        solve(k+1);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> N;
    for(int i=0; i<N; ++i) {
        int tmp;
        cin >> tmp;
        set.push_back(tmp);
    }
    solve(0);

    sort(sums.begin(), sums.end());

    unique(sums.begin(), sums.end());
    int ans;
    for(ans = 1; ans < sums.size(); ++ans) {
        if(sums[ans] != ans) break;
    } 
    cout << ans << '\n';

    return 0;
}