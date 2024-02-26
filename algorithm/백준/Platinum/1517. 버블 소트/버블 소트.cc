#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

typedef long long ll;

ll cnt = 0;

int rslt[500001];

void merge(vector<int>& v, int start, int end) {
    int mid = (start + end) /2;
    int i = start, j = mid+1;
    int idx = start;

    while(i <= mid && j <= end) {
        if(v[i] > v[j]) {
            cnt += (ll)(mid - i + 1);
            //cout << v[i] << ' ' << v[j] << '\n';
            rslt[idx++] = v[j++];
        } else if(v[i] <= v[j]) {
            rslt[idx++] = v[i++];
        }

    }

    while(i <= mid) {
        rslt[idx++] = v[i++];
    }

    while(j<=end) {
        rslt[idx++] = v[j++];
    }

    for(int t = start; t <= end; ++t) v[t] = rslt[t]; //결과값 저장 깜빡했다
}

void merge_sort(vector<int>& v, int s, int e) {

    if(s >= e) return;
    int mid = (s + e) /2;

    merge_sort(v, s, mid);
    merge_sort(v, mid+1, e);

    merge(v, s, e);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int N;
    cin >> N;

    vector<int> v(N+1);

    for(int i=1; i<=N; ++i) {
        cin >> v[i];
    }

    cnt = 0;
    merge_sort(v, 1, N);

    cout << cnt << '\n';

    return 0;
}