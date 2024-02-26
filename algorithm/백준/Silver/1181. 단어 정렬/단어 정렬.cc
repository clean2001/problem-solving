#include <iostream>
#include <vector>
#include <cstring>
#include <algorithm>
using namespace std;

bool Compare(string a, string b) {
    if(a.length() != b.length()) {
        return a.length() < b.length();
    } else {
        return a < b;
    }
}

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(0);


    int N;
    cin >> N;
    vector<string> v;
    

    for(int i=0; i<N; ++i) {
        string s;
        cin >> s;
        v.push_back(s);
    }

    sort(v.begin(), v.end(), Compare);

    cout << v[0] << '\n';
    for(int i=1; i<v.size(); ++i) {
        if(v[i] == v[i-1]) continue;
        cout << v[i] << '\n';
    }

    return 0;
}