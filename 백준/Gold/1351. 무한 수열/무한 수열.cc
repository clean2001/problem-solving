#include <iostream>
#include <algorithm>
#include <vector>
#include <map>
using namespace std;
//map을 써서 해결하는 dp문제
//수가 짱커서 메모리 초과임 하지만 밀도는 낮음 -> map 사용

typedef long long ll;

map<ll, ll> m;

ll dp(ll N, ll P, ll Q) {
    if(N==0) return 1;
    if(m.find(N) != m.end()) return m[N];

    m.insert(pair<ll, ll>(N, dp(N/P, P, Q) + dp(N/Q, P, Q)));
    return m[N];
}
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    ll N, P, Q;

    cin >> N >> P >> Q;
    
    ll ans = dp(N, P, Q);

    cout << ans << '\n';
    return 0;
}