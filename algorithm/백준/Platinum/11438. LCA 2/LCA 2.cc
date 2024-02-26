#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
using namespace std;

const int MAX_NODE = 100001;
int N;

vector<int> adj[MAX_NODE];
int depth[MAX_NODE];
int parent[MAX_NODE][17];

void make_tree(int c, int p, int d) {
    depth[c] = d;
    parent[c][0] = p;
    for(int i=1; i<=16; ++i) {
        parent[c][i] = parent[parent[c][i-1]][i-1];
        //cout << parent[c][i] << ' ';
    }
    for(int next : adj[c]) {
        if(next == p) continue;
        //cout << "nn:" << next << '\n';
        make_tree(next, c, d+1);
    }

}


int LCA(int a, int b) {
    if (a == 1 || b == 1) return 1;

    int aa = a, bb = b;

    if(depth[aa] < depth[bb]) swap(aa, bb);

    if(depth[aa] != depth[bb]) {
        for(int i=16; i>=0; --i) {
            if(depth[parent[aa][i]] >= depth[bb])
                aa = parent[aa][i];
        }
    }

    int ans = aa;
    if(aa != bb) {
        for(int i=16; i>=0; i--) {
            if(parent[aa][i] != parent[bb][i]) {
                aa = parent[aa][i];
                bb = parent[bb][i];
            }
            ans = parent[aa][i];
        }
    }

    return ans;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    
    //int N;
    cin >> N;
    for(int i=0; i<N-1; ++i) {
        int a ,b;
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }

    // for(int i=0; i<=N; ++i) {
    //     parent[0][i] = 0;
    //     parent[1][i] = 0;
    // }

    depth[0] = 0;
    depth[1] = 0;
    make_tree(1, 0, 1);

    int M;
    cin >> M;
    for(int i=0; i<M; ++i) {
        int a, b;
        cin >> a >> b;
        //int ans = 1;
        int ans = LCA(a, b);
        cout << ans << '\n';
    }

    return 0;
}