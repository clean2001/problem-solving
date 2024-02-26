#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    int q[10001] = {0};
    int front=0, rear=-1;


    string s;
    for(int i=0; i<N; ++i) {
        cin >> s;
        
        if(s == "push") {
            int num;
            cin >> num;
            q[(++rear)%N] = num;
        } else if(s == "pop") {
            if(front > rear) {
                cout << -1 << '\n';
                continue;
            }
            cout << q[front++] << '\n';
        } else if(s == "size") {
            cout << rear - front + 1 << '\n';
        } else if(s == "empty") {
            if(rear < front) cout << 1 << '\n';
            else cout << 0 << '\n';
        } else if(s == "front") {
            if(rear < front) {
                cout << -1 << '\n';
                continue;
            }
            cout << q[front] << '\n';
        } else if(s == "back") {
            if(rear < front) {
                cout << -1 << '\n';
                continue;
            }
            cout << q[rear] << '\n';
        }
        
    }    

    return 0;
}