#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
//브루트포스
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;
    for(int i=1; i<N; ++i) {
        int sum = i;
        for(int j = i; j>0; j /= 10) {
            sum +=j %10;
            //cout << "i , j :" << i << ' ' << j <<'\n';
        }
        
        if(sum == N) {
            cout << i << '\n';
            return 0;
        }
    }
    cout << 0 << '\n';
    return 0;
}