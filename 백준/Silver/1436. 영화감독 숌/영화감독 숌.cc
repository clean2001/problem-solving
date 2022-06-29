#include <iostream>
#include <algorithm>
#include <vector>
#include <sstream>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int N;
    cin >> N;

    int i = 0, cnt = 0;
    while(cnt < N) {
        stringstream ssi;
        ssi << i;

        if(ssi.str().find("666") != string::npos) cnt++;
        i++;
    }

    cout << i-1 << '\n';
    return 0;
}