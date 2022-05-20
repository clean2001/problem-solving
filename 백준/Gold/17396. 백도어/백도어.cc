#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <tuple>
using namespace std;

long long const MAX_N = 100002;
long long const INF = 1e18;
long long time[MAX_N];
vector<vector<pair<long long, long long>>> adj;


void Dijkstra(long long start)
{
    fill(time, time + MAX_N, INF);
    priority_queue<pair<long long, long long>> pq;

    pq.push({0, start});

    while(!pq.empty())
    {
        long long u, v;
        long long t,w;
        
        t = pq.top().first;
        u = pq.top().second;
        pq.pop();

        if(time[u] < INF) continue;
        time[u] = -t;

        for(pair<long long, long long> e : adj[u])
        {
            tie(w, v) = e;

            if(time[v] < INF) continue;
            pq.push({t - w, v});
        }

    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    
    int N, M;

    cin >> N >> M;

    bool visible[MAX_N];

    for(int i=0; i<N; i++)
    {   
        int is_v;
        cin >> is_v;
        if(is_v == 1) visible[i] = true;
        else visible[i] = false;
        vector<pair<long long, long long>> v;
        adj.push_back(v);
    }
    visible[N-1] = 0;

    for(int i=0; i<M; i++)
    {
        long long a, b, t;

        cin >> a >> b >> t;
        
        if(visible[a] == true || visible[b] == true) continue;
        adj[a].push_back({t, b});
        adj[b].push_back({t, a});
    }

    Dijkstra(0);

    if(time[N-1] >= INF)
        cout << -1 << '\n';
    else
        cout << time[N-1] << '\n';

    return 0;
}