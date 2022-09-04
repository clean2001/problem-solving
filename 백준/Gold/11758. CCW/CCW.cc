#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

#define x first
#define y second

typedef long long ll;
using point = pair<ll, ll>;
using vec = pair<ll, ll>;

vec get_vector(vec& a, vec& b) {
    return {b.x - a.x, b.y - a.y};
}

void ccw(vec& u, vec& v) {
    ll cp = u.x * v.y - u.y * v.x;
    
    if(cp < 0) cout << -1 << '\n';
    else if(!cp) cout << 0 << '\n';
    else cout << 1 << '\n';
}

void ccw(point& a, point& b, point& c) {
    vec u = get_vector(a, b);
    vec v = get_vector(b, c);
    ccw(u, v);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    point arr[3];
    for(int i=0; i<3; ++i ){
        int a, b;
        cin >> a >> b;
        arr[i] = {a, b};
    }
    
    ccw(arr[0], arr[1], arr[2]);

    return 0;
}