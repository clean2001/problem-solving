#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <sstream>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    char del = 'X';
    
    int T;
    cin >> T;
            cin.ignore();

    for(int i=0; i<T; ++i) {
        
        string line;
        int ans = 0;
        getline(cin, line);
        string tmp;
        stringstream f(line);
        while(getline(f, tmp, del)) {
            for(int k=1; k<=tmp.size(); ++k) ans += k;
        }

        cout << ans << '\n';
    }

    return 0;
}