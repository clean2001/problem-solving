#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;
    int arr[10001] = {0};

    for(int i=0; i<N; ++i) {
        int num;
        cin >> num;
        arr[num]++;
    }
    
    for(int i=1; i<10001; ++i) {
        if(arr[i] == 0) continue;
        for(int j=0; j<arr[i]; ++j) {
            cout << i << '\n';
        }
    }
    return 0;
}