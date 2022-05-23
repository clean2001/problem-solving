#include <iostream>
#include <algorithm>
using namespace std;

//int adj[201][201];
int parent[201];
int city[1001];

int Find(int node) {
    if(parent[node] == node)
        return node;
    else
        return parent[node] = Find(parent[node]);
}

void Union(int a, int b) {
    int r1 = Find(a);
    int r2 = Find(b);

    r2[parent] = r1;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int N, M;

    cin >> N >> M;

    for(int i=1; i<=N; ++i) {
        parent[i] = i;
    }

    for(int i=1; i<=N; ++i)
    {
        for(int j=1; j<=N; ++j) {
            int k;
            cin >> k;

            if(k == 1)
                Union(i, j);
        }
    }

    for(int i=1; i<=M; ++i)
    {
        int a;
        cin >> a;
        city[i] = a;
    }

    bool flag = true;
    for(int i=1; i<M; ++i)
    {
        if(Find(city[i]) != Find(city[i+1])) {
            flag = false;
            break;
        }
    }

    if(flag)
        cout << "YES\n";
    else
        cout << "NO\n";

    return 0;
    
}