#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int x, y, w, h;
    cin >> x >> y >> w >> h;

    int m = min({x, y, w-x, h-y});

    cout << m << '\n';

    return 0;
}