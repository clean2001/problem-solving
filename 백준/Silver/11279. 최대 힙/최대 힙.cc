#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    priority_queue<int> pq;

    int N;
    cin >> N;

    for(int i=0; i<N; ++i) {
        int x;
        cin >> x;
        if(x==0 && pq.empty()) cout << 0 << '\n';
        else if(x==0 && !pq.empty()) {
            cout << pq.top() << '\n';
            pq.pop();
        }
        else {
            pq.push(x);
        }

    }

    return 0;
}