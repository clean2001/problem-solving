#include <iostream>
#include <algorithm>
#include <vector>
#include <deque>
using namespace std;

int t[100001];
bool visit[100001];

int BFS(int N, int K) {
    fill(t, t+100001, 0);
    fill(visit, visit+100001, false);

    deque<int> d;
    d.push_front(N);
    visit[N] = true;
    while(!d.empty()) {
        int current = d.front();
        d.pop_front();

        if(current == K) return t[current];
        
        if(current*2 <= 100000 && visit[current*2] == false) { //weight = 0
            d.push_front(current*2);
            visit[current*2] = true;
            t[current*2] = t[current];
        }

        if(current+1 <= 100000 && visit[current+1] == false){ //weight = 1
            d.push_back(current+1);
            visit[current+1] = true;
            t[current+1] = t[current] + 1;
        }

        if(current-1 >= 0 && visit[current-1] == false) { //weight = 1
            d.push_back(current-1);
            visit[current-1] = true;
            t[current-1] = t[current] + 1;
        }

    }
    
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, K;
    cin >> N >> K;

    int ans = BFS(N, K);

    cout << ans << '\n';
    
    return 0;
}