#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

const long long INF = 1e9;

int N, M;
vector< pair<int, int>> adj[501];
long long dist[501];

bool bf(int s) {
    dist[1] = 0;

    for(int i=1; i<=N; ++i) {
        for(int j=1; j<=N; ++j) {
            for(auto edge : adj[j]) {
                if(dist[j] != INF && dist[edge.first] > dist[j] + edge.second) {
                    dist[edge.first] = dist[j] + edge.second;

                    if(i == N) return true;
                }
            }
        }
    }

    return false;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    fill(dist, dist+501, INF);

    cin >> N >> M;
    for(int i=0; i<M; ++i) {
        int s, e, w;
        cin >> s >> e >> w;

        adj[s].push_back({e, w});
    }

    bool is_negative_cycle = bf(1);

    if(is_negative_cycle) {
        cout << -1 << '\n';
        return 0;
    } else {
        for(int i=2; i<=N; ++i) {
            if(dist[i] == INF) cout << -1 << '\n';
            else cout << dist[i] << '\n';
        }
    }
    
    return 0;
}