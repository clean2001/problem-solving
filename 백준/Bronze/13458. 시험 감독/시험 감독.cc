#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

typedef long long ll;

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

    int B, C;
    cin >> B >> C;

    ll ans = 0;

    for(int i=0; i<N; ++i) {
        v[i] -= B;
        ans++;

        if(v[i] > 0) {
            ans += v[i] / C;
        }

        if(v[i] % C > 0) ans++;
    }

    cout << ans << '\n';
    
    return 0;
}