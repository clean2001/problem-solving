#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int max_weight;
int max_node;
bool visit[100001];

vector<pair<int, int>> adj[100001]; // first:weight, second:node;

void DFS(int current, int weight) {
    if(visit[current]) return;

    visit[current] = true;
    for(pair<int, int> next : adj[current]) {
        if(visit[next.second]) continue;

        int w = weight + next.first;
        if(w > max_weight) {
            max_weight = w;
            max_node = next.second;
        }

        DFS(next.second, w);
    }
    
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int V;
    cin >> V;
    for(int i=0; i<V; ++i) {
        int node;
        cin >> node;
        int input = 1;
        int turn = 0;
        int next, weight;
        while(true) {
            cin >> input;
            if(input == -1) break;

            if(turn % 2 == 0) {
                next = input;
            } else {
                weight = input;
                adj[node].push_back({weight, next});
                adj[next].push_back({weight, node});
            }
            turn++;
        }
    }

    max_weight = 0;
    fill(visit, visit+100001, false);
    DFS(1, 0);

    max_weight = 0;
    fill(visit, visit+100001, false);
    DFS(max_node, 0);

    cout << max_weight << '\n';
    
    return 0;
}