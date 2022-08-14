#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

typedef long long ll;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    ll a = 1, b =1, c=1;
    while(true) {
        cin >> a >> b >> c;

        if(!a && !b && !c) break;

        ll C = a*a + b*b;
        ll B = c*c + a*a;
        ll A = b*b + c*c;

        if(a*a == A || b*b == B || c*c == C) {
            cout << "right\n";
        } else {
            cout << "wrong\n";
        }
    }
    
    return 0;
}