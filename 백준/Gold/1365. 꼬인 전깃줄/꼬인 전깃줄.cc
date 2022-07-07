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
    vector<int> LIS;

    for(int i=0; i<N; ++i) {
        int tmp;
        cin >> tmp;
        v.push_back(tmp);
    }
    
    for(int i=0; i<N; ++i) {
        int lb = lower_bound(LIS.begin(), LIS.end(), v[i]) - LIS.begin();

        if(lb == LIS.size()) LIS.push_back(v[i]);
        else LIS[lb] = v[i];
    }
    
    cout << N - LIS.size() << '\n';
    return 0;
}