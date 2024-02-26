#include <iostream>
#include <algorithm>
#include <queue>
using namespace std;

int parent[100002];

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
        return parent[node] = Find(parent[node]);
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

    for(int i=1; i<=N; i++)
        parent[i] = i;

    for(int i=0; i<M; ++i)
    {
        int A, B, C;
        cin >> A >> B >> C;
        Edge e;
        e.start = A; e.end = B; e.weight = C;

        pq.push(e);
    }

    int sum = 0;
    int maxWeight = -1;
    while(!pq.empty())
    {
        Edge edge = pq.top();
        pq.pop();
        if(Find(edge.start) != Find(edge.end))
        {
            Union(edge.start, edge.end);
            sum += edge.weight;
            
            if(maxWeight < edge.weight)
                maxWeight = edge.weight;
        }
    }

    int ans = sum - maxWeight; 
    cout << ans << '\n';

    return 0;
}