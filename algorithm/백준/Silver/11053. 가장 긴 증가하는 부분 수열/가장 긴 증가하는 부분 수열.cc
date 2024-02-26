#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    vector<int> v(N);
    vector<int> LIS;

    for(int i=0; i<N; ++i) cin >> v[i];

    LIS.push_back(v[0]);
    for(int i=1; i<N; ++i) {
        int idx = lower_bound(LIS.begin(), LIS.end(), v[i]) - LIS.begin();

        if(idx == LIS.size()) LIS.push_back(v[i]);
        else LIS[idx] = v[i]; 
    }

    cout << LIS.size() << '\n';

    return 0;
}