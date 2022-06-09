#include <iostream>
#include <vector>
#include <queue>
using namespace std;
int main() {
    int N, M;

    cin >> N >> M;
    vector<int> adj[32001];
    vector<int> indegree(N+1, 0);
    vector<bool> visit(N+1, false);

    for(int i=0; i<M; ++i) {
        int s, d;
        cin >> s >> d;
        adj[s].push_back(d);
        indegree[d]++;
    }

    queue<int> q;
    for(int i=1; i<=N; ++i) {
        if(indegree[i] == 0) {
            q.push(i);
            visit[i] = true;
        }
    }

    vector<int> sort;
    while(!q.empty()) {
        int v = q.front();
        q.pop();
        sort.push_back(v);
        
        for(int d : adj[v]) {
            indegree[d]--;

            if(indegree[d] == 0 && visit[d] == false) {
            q.push(d);
            visit[d] = true;
            }
        }
        
    }
    for(int s : sort) cout << s << ' ';
    cout << '\n';
    return 0;
}