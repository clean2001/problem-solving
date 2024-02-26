#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

typedef long long ll;
vector<ll> height;

bool can_make(ll M, ll mid) {
    ll total = 0;
    for(int h: height) {
        if(h >= mid) total += h-mid;
    }

    if(total >= M) return true;
    else return false;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    ll M;


    cin >> N >> M;

    for(int i=0; i<N; ++i) {
        ll tmp;
        cin >> tmp;
        height.push_back(tmp);
    }

    ll left = 1;
    ll right = (ll)(*max_element(height.begin(), height.end()));
    ll ans = 0;
    while(left <= right) {
        ll mid = (left + right) / 2;

        if(can_make(M, mid)) {
            ans = mid;
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    cout << ans << '\n';
    return 0;
}