#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

string add_big_num(string a, string b) {
    int carry = 0;
    string rslt = "";

    while(!a.empty() || !b.empty() || carry) {
        if(!a.empty()) {
            carry += a.back() - '0';
            a.pop_back();
        }

        if(!b.empty()) {
            carry += b.back() - '0';
            b.pop_back();
        }
        rslt.push_back((carry % 10) + '0');
        carry /= 10;
    }

    reverse(rslt.begin(), rslt.end());
    return rslt;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    string a, b;
    cin >> a;
    cin >> b;

    string ans = add_big_num(a, b);

    cout << ans << '\n';

    return 0;
}