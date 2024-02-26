#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    int stack[10001] = {0};
    int idx = -1;

    for(int i=0; i<N; ++i) {
        string s;
        cin >> s;
        if(s=="push") {
            int n;
            cin >> n;
            stack[++idx] = n;
        } else if(s=="top") {
            if(idx == -1) cout << -1 << '\n';
            else cout << stack[idx] << '\n';
        } else if(s=="size") {
            cout << idx+1 << '\n';
        } else if(s=="empty") {
            if(idx == -1) cout << 1<<'\n';
            else cout << 0 << '\n';
        } else if(s=="pop") {
            if(idx == -1) cout << -1 << '\n';
            else cout << stack[idx--] << '\n';
        }
    }
    return 0;
}