#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
using namespace std;

vector<pair<int, int>> adj[10001];
bool visit[10001];
int max_weight;
int max_node;

void DFS(int current, int weight) {
    if(visit[current]) return;

    visit[current] = true;
    for(pair<int, int> p : adj[current]) {
        if(visit[p.second]) continue;
        
        int tmp = weight + p.first;
        if(max_weight < tmp) {
            max_weight = tmp;
            max_node = p.second;
            //cout << "mw:" << max_weight << "  mn:" << max_node << '\n';
        }

        DFS(p.second, tmp);
    }
    
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int N;
    cin >> N;
    for(int i=1; i<N; ++i) {
        int p, c, w;
        cin >> p >> c >> w;

        adj[c].push_back({w, p});
        adj[p].push_back({w, c});
    }

    fill(visit, visit+10001, false);
    max_weight = 0;
    DFS(1, 0);
    //cout << "max_node: " << max_node << '\n';

    fill(visit, visit+10001, false);
    max_weight = 0;
    DFS(max_node, 0);

    cout << max_weight << '\n';
    return 0;
}