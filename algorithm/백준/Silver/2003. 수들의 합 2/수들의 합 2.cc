#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M;
    cin >> N >> M;

    vector<int> v;
    for(int i=0; i<N; ++i) {
        int tmp;
        cin >> tmp;
        v.push_back(tmp);
    }

    //sort(v.begin(), v.end());

    //for(int i=0; i<N; ++i) cout << v[i] <<' ';

    int i = 0, j = 0;
    int sum = v[0];
    int ans = 0;
    while(j < N) {
        if(sum < M) {
            sum += v[++j];
        } else if(sum > M) {
            sum -= v[i++];
        } else {
            ++ans;
            sum -= v[i++];
            sum += v[++j];
        }
    }

    cout << ans << '\n';
    
    return 0;
}