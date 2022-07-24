#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

bool compare(pair<int, string> p1, pair<int, string> p2) {

    return p1.first < p2.first;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    vector<pair<int, string>> v;
    for(int i=0; i<N; ++i) {
        int y;
        string n;
        cin >> y >> n;
        v.push_back({y, n});
    }

    stable_sort(v.begin(), v.end(), compare);

    for(pair<int, string> tmp : v)
        cout << tmp.first << ' ' << tmp.second << '\n';
    
    return 0;
}