#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

const int INF = 1e9;

int parent[500001];

int Find(int n1) {
    if(parent[n1] <= 0) return n1;

    return parent[n1] = Find(parent[n1]);
}

int Union(int n1, int n2) {
    int r1 = Find(n1);
    int r2 = Find(n2);

    if(r1 == r2) {
        return -1;
    }

    if(parent[r1] <= parent[r2]) { //r1의 높이가 더 높을때
        parent[r2] = r1;
        parent[r1]--;
    } else {
        parent[r1] = r2;
        parent[r2]--;
    }

    return 0;

}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M;
    cin >> N >> M;
    
    fill(parent, parent+500001, 0);
    int ans = 0;
    for(int i=1; i<=M; ++i) {
        int s, e;
        cin >> s >> e;

        int is_cycle = Union(s+1, e+1);

        if(is_cycle == -1 && !ans) {
            ans = i;
        }

    }
    
    cout << ans << '\n';
    return 0;
}