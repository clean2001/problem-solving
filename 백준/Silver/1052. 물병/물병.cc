#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, K;
    cin >> N >> K;

    int ans = 0;
    int count =0;
    for(; ; ++ans) {
        count = 0;
        
        for(int num = N + ans; num > 0; num/=2) {
            if((num) % 2 ==1 ) {
                count++;
            }
        }
        if(count<=K) break;

    }
    
    cout << ans << '\n';
    return 0;
}