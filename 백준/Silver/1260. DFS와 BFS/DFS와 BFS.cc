#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

vector<vector<int>> adj(1002);
vector<bool> visit(1002, false);

void DFS(int current);
void BFS(int start);

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int N=0, M=0, V=0;

    cin >> N >> M >> V;

    for(int i=0; i< M; ++i)
    {
        int n1, n2;

        cin >> n1 >> n2;

        adj[n1].push_back(n2);
        adj[n2].push_back(n1);
    }

    for(int i=1; i<=N; i++)
    {
        sort(adj[i].begin(), adj[i].end());
    }

    DFS(V);
    fill(visit.begin(), visit.end(), false);
    cout << '\n';
    BFS(V);


    return 0;
}

void DFS(int current) {

    visit[current] = true;
    cout << current << ' ';
    for(int i=0; i<int(adj[current].size()); i++) {
        int next = adj[current][i];
        if(visit[next]) continue;
        DFS(next);
    }
}

void BFS(int start) {
    queue<int> q;

    visit[start] = true;
    q.push(start);

    while(!q.empty()) {
        int current = q.front();
        cout << current << ' ';
        q.pop();

        for(int i=0; i<int(adj[current].size()); ++i) {
            int next = adj[current][i];
            if(visit[next]) continue;
            visit[next] = true;
            q.push(next);
        }
    }
}