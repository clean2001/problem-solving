#include <iostream>
#include <algorithm>
#include <vector>
#include <sstream>
using namespace std;

int wordCounter(string str, char delimiter);

int main()
{
    /*ios_base::sync_with_stdio(false);
    cin.tie(0);*/

    int cnt = 0;
    string str;
    getline(cin, str);

    if(str[0] == ' ')
        str.erase(str.begin());
    if(str[str.size() - 1] == ' ')
        str.erase(str.end() - 1);
    
    cnt = wordCounter(str, ' ');
    cout << cnt << '\n';
    return 0;
}

int wordCounter(string str, char delimiter) {
    stringstream ss(str);
    string tmp;
    vector<string> v;

    while(getline(ss, tmp, delimiter)) {
        v.push_back(tmp);
    }
    return v.size();
}