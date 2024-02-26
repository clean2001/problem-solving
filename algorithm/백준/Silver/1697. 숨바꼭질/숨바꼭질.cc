#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

const int INF = 987654321;

int cnt[100002];

void BFS(int N, int K) {
    queue<int> q;
    cnt[N] = 0;
    q.push(N);

    int current = -1;
    while(!q.empty() && current != K) {
        current = q.front();
        q.pop();

        if(current+1 <= 100000 && cnt[current+1] >= INF) {
            q.push(current+1);
            cnt[current+1] = cnt[current] + 1;
        }

        if(current-1 >= 0 && cnt[current-1] >= INF) {
            q.push(current-1);
            cnt[current-1] = cnt[current] + 1;
        }

        if(current*2 <= 100000 && cnt[current*2] >= INF) {
            q.push(current*2);
            cnt[current*2] = cnt[current] + 1;
        }
        
        if(current == K) break;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, K;
    cin >> N >> K;

    fill(cnt, cnt+100001, INF);

    BFS(N, K);

    cout << cnt[K] << '\n';

    return 0;
}