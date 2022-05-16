#include <iostream>
#include <algorithm>
#include <vector>
#include <tuple>
#include <queue>
using namespace std;

#define INF 987654321
#define VMAX 20000

vector<pair<int, int>> adj[VMAX + 2];
int dist[VMAX + 2];
int length =0;

void Dijkstra(int start)
{
    fill(dist, dist + VMAX +1, INF);
    priority_queue<pair<int, int>> pq;
    pq.push({0, start});

    while(!pq.empty()) {
        int u, v, d, w;
        tie(d, u) = pq.top();
        pq.pop();

        if(dist[u] < INF) continue;

        dist[u] = -d;
        length++;

        for(pair<int, int> e : adj[u]) {
            tie(w, v) = e;
            if(dist[v] < INF) continue;
            pq.push({d - w, v});
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int V, E;
    int K;
    int u, v, w;

    cin >> V >> E >> K;

    for(int i=0; i<E; i++) {
        cin >> u >> v >> w;

        adj[u].push_back({w, v}); //인접행렬 정의에 따라서 (근데 정하기 나름임)
    }

    Dijkstra(K);

    for(int i= 1; i<=V; ++i)
    {
        if(dist[i] >= 987654321)
            cout << "INF\n";
        else
            cout << dist[i] << '\n';
    }
    
    return 0;
}