#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    stack<int> s;
    vector<char> op;

    int n;
    cin >> n;

    int maxN = 0;
    int current;
    int prev = 0;
    for(int i=0; i<n; ++i) {
        
        cin >> current;

        if(current > maxN) {
            op.push_back('+');
            for(int j=1; j<current-maxN; ++j) {
                s.push(maxN+j);
                op.push_back('+');
            }
            op.push_back('-');
        } else if(current < maxN && s.top() == current) {
            s.pop();
            op.push_back('-');
        } else {
            cout << "NO\n";
            return 0;
        }

        maxN = max(maxN, current);
        prev = current;
    }

    for(int i=0; i<op.size(); ++i) cout << op[i] <<'\n';
    return 0;
}