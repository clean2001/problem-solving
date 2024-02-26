#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

vector<vector<int>> adj(101);
bool visit[101];
int record[101];

int BFS(int s, int e) {
    fill(visit, visit+101, false);
    fill(record, record+101, 0);

    queue<int> q;
    q.push(s);
    visit[s] = true;
    int cnt = 0;

    while(!q.empty()) {
        int current;
        current = q.front();
        q.pop();

        if(current == e) {
            return record[e];
        }
        //cout << current << '\n';

        for(int next : adj[current]) {
            if(visit[next]) continue;

            q.push(next);
            visit[next] = true;
            record[next] = record[current] + 1;
        }
    }

    return -1;
}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m, s, e;
    cin >> n >> s >> e;
    cin >> m;

    for(int i=0; i<m; ++i) {
        int x, y;
        cin >> x >> y;

        adj[x].push_back(y);
        adj[y].push_back(x);
    }

    int ans = BFS(s, e);
    cout << ans << '\n';

    return 0;
}