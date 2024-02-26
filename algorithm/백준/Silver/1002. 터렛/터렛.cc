#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
using namespace std;

typedef long long ll;

ll cal_dist(ll x1, ll x2, ll y1, ll y2) {
    ll rslt = pow(x1 - x2 , 2) + pow(y1 - y2, 2); 

    return rslt;
}

ll solve(ll x1, ll y1, ll x2, ll y2, ll r1, ll r2) {

    ll dist = cal_dist(x1, x2, y1, y2);
    //cout << "dist : " << dist << '\n';

    ll s = (r1 - r2) * (r1 - r2);
    ll a = (r1 + r2) * (r1 + r2);

    if(r1 > r2) swap(r1, r2);

    if(a > dist && dist > s) return 2;
    else if(dist == a || (dist == s && dist)) return 1;
    else if(a < dist || dist < s) return 0; 
    else if(!dist && r1 == r2) return -1;
    else return 0;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;
    for(int tc = 0; tc < T; ++tc) {
        ll x1, y1, x2, y2, r1, r2;
        cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;

        cout << solve(x1, y1, x2, y2, r1, r2) << '\n';
    }
    
    return 0;
}