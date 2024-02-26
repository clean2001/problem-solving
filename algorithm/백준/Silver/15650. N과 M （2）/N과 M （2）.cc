#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int N, M;
bool sel[10];

void DFS(int current, int cnt) {
    if(cnt == M) {
        for(int i=1; i<=N; ++i) {
            if(sel[i]) cout << i << ' ';
        }
        cout << '\n';

        return;
    }

    if(current == N+1) return;

    sel[current] = true;
    DFS(current+1, cnt+1);
    sel[current] = false;
    DFS(current+1, cnt);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N >> M;

    fill(sel, sel+10, false);
    DFS(1, 0);
    return 0;
}