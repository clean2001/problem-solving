#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

vector<int> result;

void bfs(int N, int K, int X, vector<vector<int>> adj);

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int N, M, K, X;
    cin >> N >> M >> K >> X;

    vector<vector<int>> adj(N + 1);

    for(int i=0; i<M; i++)
    {
        int from, to;
        cin >> from >> to;

        adj[from].push_back(to); //단방향 그래프
    }

    bfs(N, K, X, adj); //노드개수, 거리, 시작노드, 그래프

    sort(result.begin(), result.end());
    if(result.size() == 0)
        cout << -1 << '\n';
    else {
        for(int i=0; i< result.size(); ++i)
            cout << result[i] << '\n';
    }

    return 0;
}

void bfs(int N, int K, int X, vector<vector<int>> adj)
{
    vector<bool> visit(N+1, false);
    queue<pair<int, int>> q;

    q.push(make_pair(0, X)); //거리 0 시작 X

    while(!q.empty())
    {
        int distance = q.front().first;
        int current = q.front().second;
        q.pop();

        if(visit[current]) continue;

        visit[current] = true;

        if(distance == K)
        {
            result.push_back(current);
            continue;
        }

        for(int i=0; i< int(adj[current].size()); ++i)
        {
            int next = adj[current][i];
            if(visit[next]) continue;

            q.push(make_pair((distance + 1), next)); // 인접한 ㅗ드를 
        }
    }

}