#include <iostream>
#include <algorithm>
#include <utility>
#include <vector>
using namespace std;

int N, ans;
vector<pair<int, int>> queen;

bool is_valid(int r, int c);

void solve(int r) {
    if(r == N) {
        ans++;
        return;
    }

    for(int c = 0; c <N; ++c) {
        if(!is_valid(r,c)) continue;
        queen.push_back({r,c});
        solve(r+1);
        queen.pop_back();
    }
}

bool is_valid(int r, int c) {
    for(int i=0; i < int(queen.size()); ++i) {
        int nr = queen[i].first, nc = queen[i].second;
        if(nr == r || nc == c) return false;
        if(nr + nc == r + c || nr - nc == r - c) return false;
    }

    return true;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    cin >> N;
    
    solve(0);

    cout << ans << '\n';

    return 0;
}