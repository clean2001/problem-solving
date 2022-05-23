#include <iostream>
#include <algorithm>
#include <queue>
#include <tuple>
using namespace std;

int parent[10002];
using ti = tuple<int, int ,int>;

int Find(int node) {
    if(parent[node] == node)
        return node;
    else
        return parent[node] = Find(parent[node]);
}

void Union(int a, int b) {
    int r1 = Find(a);
    int r2 = Find(b);

    parent[r2] = r1;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int V, E;

    cin >> V >> E;

    for(int i=0; i<10002; i++)
        parent[i] = i;

    int ans = 0;
    priority_queue<ti, vector<ti>, greater<ti>> pq;

     for(int i=0; i<E; ++i)
     {
        int a, b, c;
        cin >> a >> b >> c;
        pq.push(ti(c, a, b));
     }

    int weight, start, end;
    while(!pq.empty())
    {
        ti edge = pq.top();
        pq.pop();
        weight = get<0>(edge);
        start = get<1>(edge);
        end = get<2>(edge);
        if(Find(start) != Find(end))
        {
            Union(start, end);
            ans += weight;
        }
    }
    cout << ans << '\n';
    return 0;
}