#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int N;
    
    int total = 0;
    char c[101] = "";

    cin >> N >> c;

    for(int i = 0; i < N; i++) {
        total += c[i] - '0';
    }
    
    cout << total << '\n';
    return 0;
}