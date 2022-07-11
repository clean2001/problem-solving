#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    vector<int> v;
    for(int i=0; i<N; ++i) {
        int tmp;
        cin >> tmp;
        v.push_back(tmp);
    }

    sort(v.begin(), v.end());

    int sum = 0;
    int ans = 0;
    for(int i=0; i<N; ++i) {
        sum += v[i];
        ans += sum;
    }

    cout << ans <<'\n';
    
    return 0;
}