#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

vector<vector<int>> adj(1001);
vector<bool> visit(1001, false);

int cnt = 0;

void DFS(int current)
{
    visit[current] = true;

    for(int i=0; i<adj[current].size(); i++)
    {
        int next = adj[current][i];

        if(visit[next]) continue;
        DFS(next);
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int N, M;

    cin >> N >> M;

    for(int i=0; i<M; i++)
    {
        int n1, n2;

        cin >> n1 >> n2;

        adj[n1].push_back(n2);
        adj[n2].push_back(n1);
    }

    for(int i=1; i<=N; i++)
    {
        if(visit[i]) continue;

        DFS(i);
        cnt++;
    }


    cout << cnt <<'\n';

    return 0;
}