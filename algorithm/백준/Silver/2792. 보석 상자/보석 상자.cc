#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
typedef long long ll;

vector<ll> j;

bool can_divide(ll N, int mid) {
    ll cnt = 0;
    for(int i=0; i<j.size(); ++i) {
        cnt += j[i] / mid;
        if(j[i] % mid != 0) cnt++;
    }

    if(cnt <= N) return true;
    else return false;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    ll N;
    int M;
    cin >> N >> M;

    for(int i=0; i<M; ++i) {
        ll tmp;
        cin >> tmp;
        j.push_back(tmp);
    }

    ll right = *max_element(j.begin(), j.end());
    ll left = 1;

    ll ans;
    while(left <= right) {
        ll mid = (right + left) / 2;

        if(can_divide(N, mid)) {
            right = mid - 1;
            ans = mid;
        } else {
            left = mid + 1;
        }
    }

    cout << ans << '\n';
    return 0;
}