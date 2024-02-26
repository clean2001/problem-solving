#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

char univ[1002];
int parent[1002];

struct Edge
{
    int start, end, weight;

    bool operator< (const Edge& a) const {
        return weight < a.weight;
    }
    bool operator> (const Edge& a) const {
        return weight > a.weight;
    }
};

int Find(int node)
{
    if(node == parent[node])
        return node;
    else
        return Find(parent[node]);
}

void Union(int n1, int n2)
{
    int r1 = Find(n1);
    int r2 = Find(n2);

    parent[r2] = r1;
    return;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int N, M;
    cin >> N >> M;

    priority_queue<Edge, vector<Edge>, greater<Edge>> pq;

    for(int i=1; i<=N; ++i)
        parent[i] = i;


    for(int i=1; i<=N; ++i)
        cin >> univ[i];

    for(int i=0; i<M; ++i)
    {
        int u, v, d;

        cin >> u >> v >> d;

        Edge e;
        e.start = u; e.end = v; e.weight = d;
        //cout << univ[u] << '\t' << univ[v] << '\n';
        if(univ[u] != univ[v])
            pq.push(e);
    }

    int ans = 0;
    while(!pq.empty())
    {
        Edge e = pq.top();
        pq.pop();
        if(Find(e.start) != Find(e.end)) {
            Union(e.start, e.end);
            ans += e.weight;
        }
    }

    int r = Find(1);
    for(int i=2; i<=N; i++)
    {
        //cout << r << ' ' << Find(i)<< '\n';
        if(r != Find(i)) {
            cout << -1 << '\n';
            return 0;
        }
            
    }

    cout << ans << '\n';
    return 0;
}