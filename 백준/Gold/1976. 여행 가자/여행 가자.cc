#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int parent[201];

int find(int a) {
    if(parent[a] == a) return a;
    
    return (parent[a] = find(parent[a]));

}

void uni(int a, int b) {
    int ra = find(a);
    int rb = find(b);

    if(ra == rb) return; 

    parent[rb] = ra;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int N, M;
    cin >> N >> M;

    for(int i=1; i<=N; ++i) {
        parent[i] = i;
    }

    for(int i=1; i<=N; ++i) {
        for(int j=1; j<=N; ++j) {
            int k;
            cin >> k;
            
            if(k) uni(i, j);
        }
    }

    int city;
    cin >> city;
    int root = find(city);
    bool is_ok = true;
    for(int i=1; i<M; ++i) {
        cin >> city;
        int r2 = find(city);

        if(root != r2) is_ok = false;
    }

    if(!is_ok) cout << "NO\n";
    else cout << "YES\n";
    return 0;
}