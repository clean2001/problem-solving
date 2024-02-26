#include <iostream>
#include <vector>
#include <queue>
using namespace std;

vector<int> adj[32001];
int indegree[32001];
bool visit[32001] = {false};

int main()
{
    int N,M;
    cin >> N >> M;
    for(int i=0; i<M; ++i) {
        int a, b;
        cin >> a >>b;
        adj[a].push_back(b);
        ++indegree[b];
    }

    priority_queue<int> q;
    int i;
    for(i=1; i<=N; ++i)
        if(indegree[i] == 0) {
            q.push(-i);
            visit[i] = true;
        }
    
    while(!q.empty()) {
        int current = -q.top();
        q.pop();
        cout << current << ' ';
        
        for(int j=0; j<adj[current].size(); ++j) {
            int tmp = adj[current][j];
            if(--indegree[tmp]==0 && !visit[tmp]) {
                visit[tmp] = true;
                q.push(-tmp);
            }
        }
    }
    return 0;
}