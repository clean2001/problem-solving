#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

vector<int> v;
bool chosen[9];
int N;

void permutation() {
    if(v.size() == N) {
        for(int e : v) cout << e <<' ';
        cout << '\n';
    } else {
        for(int i=1; i<=N; ++i) {
            if(chosen[i]) continue;
            chosen[i] = true;
            v.push_back(i);
            permutation();
            chosen[i] = false;
            v.pop_back();
        }
    }
    
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N;
    fill(chosen, chosen+9, false);
    
    permutation();

    return 0;
}