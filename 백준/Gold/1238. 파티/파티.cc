#include <iostream>
#include <algorithm>
#include <queue>
#include <tuple>
using namespace std;

#define INF 987654321
#define V_MAX 1002

int dist1[V_MAX];
int dist2[V_MAX];

vector<pair<int, int>> adj1[V_MAX];
vector<pair<int, int>> adj2[V_MAX];


void Dijkstra(int start, int dist[], vector<pair<int, int>> adj[])
{
    fill(dist, dist + V_MAX , INF);

    priority_queue<pair<int, int>> pq;

    pq.push({0, start});

    while(!pq.empty()) {
        int u, v, d, w;
        tie(d, u) = pq.top();
        pq.pop();

        if(dist[u] < INF) continue;
        dist[u] = -d;

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

    int N, M, X;

    cin >> N >> M >> X;
    int distTotal[V_MAX];

    for(int i=0; i <M; i++)
    {
        int s, e, t;

        cin >> s >> e >> t;

        adj1[s].push_back({t, e});
        adj2[e].push_back({t, s});

    }

    Dijkstra(X, dist1, adj1);
    Dijkstra(X, dist2, adj2);

    int max = 0;

    for(int i=1; i<= N; i++)
    {
        if(dist1[i] + dist2[i] > max)
            max = dist1[i] + dist2[i];
    }
    
    cout << max << '\n';
    return 0;
    
}