#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

vector<int> subset;
vector<int> set;
int cnt;
int N, S;

void solve(int k) {
    if(N == k) {
        int sum = 0;
        for(int e : subset)  sum += e;

        if(sum == S && subset.size()) cnt++;
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
    
    cin >> N >> S;

    for(int i=0; i<N; ++i) {
        int tmp;
        cin >> tmp;
        set.push_back(tmp);
    }

    cnt = 0;
    solve(0);

    cout << cnt << '\n';

    return 0;
}