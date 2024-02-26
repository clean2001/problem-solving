#include <iostream>
#include <algorithm>
#include <vector>
#include <tuple>
#include <queue>
using namespace std;

#define INF 987654321
#define V_MAX 802

int dist1[V_MAX];
int dist2[V_MAX];

vector<pair<int, int>> adj1[V_MAX];
int Dijkstra(int start, int dist[], vector<pair<int, int>> adj[], int X)
{
    fill(dist, dist + V_MAX, INF);
    priority_queue<pair<int, int>> pq;
    pq.push({0, start});

    while(!pq.empty()) {
        int u, v, d, w;
        tie(d, u) = pq.top();
        pq.pop();

        if(dist[u] < INF) continue;

        dist[u] = -d;

        for(pair<int, int> e : adj[u]) {
            tie(w, v) = e; //w, v 순서.....
            if(dist[v] < INF) continue;
            pq.push({d - w, v});
        }
    }

    return dist[X];
}
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int N, E;

    cin >> N >> E;

    for(int i=1; i<=E; i++)
    {
        int a, b, c;
        cin >> a >> b >> c;

        adj1[a].push_back({c, b}); //c가 거리, b가 노드
        adj1[b].push_back({c, a});
    }

    int n1, n2;
    cin >> n1 >> n2;

    long long l1 = Dijkstra(1, dist1, adj1, n1);
    long long l2 = Dijkstra(1, dist1, adj1, n2);
    long long l3 = Dijkstra(n1, dist1, adj1, n2);
    long long l4 = Dijkstra(n1, dist1, adj1, N);
    long long l5 = Dijkstra(n2, dist1, adj1, N);
    
    
    long long total1 = l2 + l3 + l4;
    long long total2 = l1 + l3 + l5;

    if(total1 >= INF && total2 >= INF)
        cout << -1 << '\n';
    else
        cout << min(total1, total2) << '\n';

    return 0;
}