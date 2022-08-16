#include <iostream>
#include <algorithm>
#include <vector>
#include <deque>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    deque<int> d;
    for(int i=1; i<=N; ++i) {
        d.push_back(i);
    }

    for(int i=1; i<N; ++i) {
        d.pop_front();
        int tmp = d.front();
        d.pop_front();
        d.push_back(tmp);
    }

    cout << d.front() << '\n';
    
    return 0;
}