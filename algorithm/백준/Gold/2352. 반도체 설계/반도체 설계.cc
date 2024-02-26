#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n;
    cin >> n;

    vector<int> port;
    vector<int> lis;

    for(int i=0; i<n; ++i) {
        int tmp;
        cin >> tmp;
        port.push_back(tmp);
    }

    for(int i=0; i<n; ++i) {
        int lb = lower_bound(lis.begin(), lis.end(), port[i]) - lis.begin();
        //cout << port[i];
        if(lb == lis.size()) lis.push_back(port[i]);
        else lis[lb] = port[i];
    }
    cout << lis.size() << '\n';

    return 0;
}