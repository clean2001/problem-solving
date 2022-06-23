#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

//typedef long long ll;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    vector<int> f(n+1);

    f[0] = 0; f[1] = 1;
    for(int i=2; i<=n; ++i) {
        f[i] = ((f[i-1]%1000000007) + (f[i-2]%1000000007)) % 1000000007;
    }

    cout << f[n] << '\n';
    return 0;
}