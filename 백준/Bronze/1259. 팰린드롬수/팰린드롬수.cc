#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    string N;
    stack<char> s;
    while(true) {
        cin >> N;
        if(N == "0") break;
        for(char c : N) {
            s.push(c);
        }

        string rs;
        while(!s.empty()) {
            rs += s.top();
            s.pop();
        }

        if(N == rs) cout << "yes\n";
        else cout << "no\n";
    }
    return 0;
}