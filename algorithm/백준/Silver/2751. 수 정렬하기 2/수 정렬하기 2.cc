#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int rslt[10000001];

void merge(vector<int>& v, int s, int mid, int e) {
    int l = s;
    int r = mid+1;
    int idx = s;
    while(r<=e && l <= mid) {
        if(v[l] <= v[r]) {
            rslt[idx++] = v[l++];
        } else {
            rslt[idx++] = v[r++];
        }

        //if(r>e || l>mid) break;
    }

    if(l > mid) {
        while(r<=e) rslt[idx++] = v[r++];
    } else {
        while(l<=mid) rslt[idx++] = v[l++];
    }

    for(int t=s; t<=e; ++t) v[t] = rslt[t];
}


void merge_sort(vector<int>& v, int s, int e) {
    if(s >= e) return;
    int mid = (s + e) / 2;
    merge_sort(v, s, mid);
    merge_sort(v, mid+1, e);
    merge(v, s, mid, e);
}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;
    vector<int> v;

    for(int i=0; i<N; ++i) {
        int num;
        cin >> num;
        v.push_back(num);
    }

    //for(int i=0; i<v.size(); i++) cout << rslt[i] << '\n';
    merge_sort(v, 0, v.size()-1);
    for(int i=0; i<v.size(); i++) cout << v[i] << '\n';
    
    return 0;
}