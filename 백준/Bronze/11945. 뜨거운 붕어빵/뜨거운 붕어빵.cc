#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M;
    cin >> N >> M;
    for(int i=0; i<N; ++i) {
        string s;
        cin >> s;

        reverse(s.begin(), s.end());
        cout << s << '\n';
    }
    
    return 0;
}