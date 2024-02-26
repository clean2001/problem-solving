#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

bool exist[21];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int M;
    cin >> M;
    fill(exist, exist+21, false);
    
    for(int i=0; i<M; ++i) {
        string s;
        int x;
        cin >> s;



        if(s=="add") {
            cin >> x;
            
            exist[x] = true;
        } else if(s == "remove") {
            cin >> x;
            exist[x] = false;
        } else if(s == "check") {
            cin >> x;
            if(exist[x]) cout << 1 <<'\n';
            else cout << 0 << '\n';
        } else if(s == "toggle") {
            cin >> x;
            if(exist[x]) exist[x] = false;
            else exist[x] = true;
        } else if(s == "all") {
            fill(exist, exist+21, true);
        } else if(s == "empty") {
            fill(exist, exist+21, false);
        }
    }
    
    return 0;
}