#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int t[1001][1001];

void BFS(queue<pair<int, int>>& q, int M, int N) {

    while(!q.empty()) {
        pair<int, int> current = q.front();
        q.pop();
        int x = current.first;
        int y = current.second;
        
        if(x-1 >= 1 && t[x-1][y] == 0) {
            q.push({x-1, y});
            t[x-1][y] = t[x][y] + 1;
        }
        if(x + 1 <= N && t[x+1][y] == 0) {
            q.push({x+1, y});
            t[x+1][y] = t[x][y] + 1;
        }
        if(y-1 >= 1 && t[x][y-1] == 0) {
            q.push({x, y-1});
            t[x][y-1] = t[x][y] + 1;
        }
        if(y+1 <= M && t[x][y+1] == 0) {
            q.push({x, y+1});
            t[x][y+1] = t[x][y] + 1;
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int M, N;
    cin >> M >> N;

    queue<pair<int, int>> ripe;

    /*input*/
    for(int i=1; i<=N; ++i) {
        for(int j=1; j<=M; ++j) {
            cin >> t[i][j];
            if(t[i][j] == 1) ripe.push({i,j});
        }
    }

    BFS(ripe, M, N);

    bool flag = false;
    int ans = -1;
    for(int i=1; i<=N; ++i) {
        for(int j=1; j<=M; ++j) {
            if(t[i][j] == 0) {
                flag = true;
                break;
            }

            if(t[i][j] > ans) ans = t[i][j];
        }
    }

    if(flag==true) cout << -1 << '\n';
    else cout << ans-1 << '\n';
    return 0;
}