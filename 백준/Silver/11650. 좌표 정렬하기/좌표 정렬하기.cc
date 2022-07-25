#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

bool compare(pair<int, int> p1, pair<int, int> p2) {
    if(p1.first != p2.first) return p1.first < p2.first;

    return p1.second < p2.second;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    vector<pair<int, int>> v;
    for(int i=0; i<N; ++i) {
        int x, y;
        cin >> x >> y;
        v.push_back({x, y});
    }

    sort(v.begin(), v.end(), compare);

    for(pair<int, int> p : v) {
        cout << p.first << ' ' << p.second << '\n';
    }

    
    return 0;
}