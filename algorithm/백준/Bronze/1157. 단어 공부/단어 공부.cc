#include <iostream>
#include <algorithm>
#include <vector>
#include <sstream>
#include <string>
using namespace std;

int main()
{
    string str;
    int ascii[128] = {0};
    cin >> str;
    transform(str.begin(), str.end(), str.begin(), ::toupper);

    int max = -1;
    int maxIdx = -1;
    for(char c : str) {
        ascii[c]++;

        if(ascii[c]>max) {
            max = ascii[c];
            maxIdx = c;
        }
    }

    int cntOfMax = 0;
    for(int i='A'; i<='Z'; i++) {
        if(ascii[i] == max)
            cntOfMax++;
    }

    if(cntOfMax > 1) {
        cout << "?\n";
        return 0;
    }

    cout << (char)maxIdx << '\n';
    return 0;
}