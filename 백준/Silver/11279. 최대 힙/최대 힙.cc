#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

const int MAX = 100000;

int h[MAX+1];
int size_h;

int deleteMax() { /*percolating down*/
    if(size_h == 0) return 0;

    int last, max;
    max = h[1];
    last = h[size_h--];

    // for(int i=1; i<=size_h; ++i) cout << h[i] <<' ';
    // cout << '\n';

    int i, child;
    for(i = 1; i*2 <= size_h; i = child) {
        child = i*2;
        if(child < size_h && h[child] < h[child+1]) child++;

        if(h[child] > last) h[i] = h[child];
        else break;
    }

    h[i] = last;

    // cout << "after:\n";
    // for(int i=1; i<=size_h; ++i) cout << h[i] <<' ';
    // cout << '\n';

    return max;
}

void insert(int n) { /*percolating up*/
    int i;
    for(i = ++size_h; i/2 >= 1 && h[i/2] < n; i/=2) {
        h[i] = h[i/2];
    }

    h[i] = n;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int N;
    cin >> N;

    h[0] = 0;
    size_h = 0;

    for(int i=0; i<N; ++i) {
        int x;
        cin >> x;

        if(x == 0) cout << deleteMax() << '\n';
        else insert(x);
    }

    return 0;
}