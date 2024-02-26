#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

const int MAX = 100000;

int h[MAX+1];
int size_h = 0;

int deleteMin() {
    if(size_h ==0) return 0;

    int last, min;
    min = h[1];
    last = h[size_h--];

    int i, child;
    for(i=1; i*2<=size_h; i = child) {  //진짜 진짜 얼탱없는 실수... 여기 int i=1이라함... 그럼 이상한 값 나옴
        child = i*2;

        if(child != size_h && h[child] > h[child+1]) child++;

        if(h[child] < last) {
            h[i] = h[child];
        } 
        else break;
    }

    h[i] = last;

    //cout << "after:\n";
    //for(int i=1; i<=size_h; ++i) cout << h[i] << ' ';
    //cout << '\n';
    
    //cout << min <<'\n';
    return min;
}

void insert(int n) {
    int i;
    for(i = ++size_h; i/2 >= 1 && h[i/2] > n; i /= 2) {
        h[i] = h[i/2];
    }

    h[i] = n;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    fill(h, h+MAX+1, 0);
    h[0] = -999;
    size_h = 0;

    int N;
    cin >> N;
    for(int i=0; i<N; ++i) {
        int x;
        cin >> x;
        if(x == 0)  {
            int ans = deleteMin();
            cout << ans << '\n';
        }
        else {
            insert(x);
        } 
    }

    return 0;
}