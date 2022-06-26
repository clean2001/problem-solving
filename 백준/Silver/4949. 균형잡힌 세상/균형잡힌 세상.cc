#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    string tmp;
    
    stack<char> s;

    while(1) {
        getline(cin, tmp);
        if(tmp[0] == '.') break;

        bool flag = true;
        for(int i=0; tmp[i] != '.'; i++) {
            if(tmp[i] == '(' || tmp[i] == '[')
                s.push(tmp[i]);
            
            if(tmp[i] == ')' || tmp[i] == ']') {
                if(s.empty()) {
                    flag = false;
                    break;
                }

                int c= s.top();

                if(tmp[i] == ')' && c == '(') {
                    s.pop();
                    continue;
                }

                if(tmp[i] == ']' && c == '[') {
                    s.pop();
                    continue;
                }
                flag = false;
                break;
            }
        }

        if(!s.empty()) {
            flag = false;
            while( !s.empty() ) s.pop();
        }

        if(flag) cout << "yes\n";
        else cout << "no\n";

        while( !s.empty() ) s.pop();
    }

    return 0;
}