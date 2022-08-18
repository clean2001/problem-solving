#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

typedef long long ll;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    ll S, N;

    cin >> S;

    ll sum = 0;
    int num = 0;
    while(sum <= S) {
        num++;
        sum += num;
    }
    
    cout << num-1 << '\n';

    return 0;
}