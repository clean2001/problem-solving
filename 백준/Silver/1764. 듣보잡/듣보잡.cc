#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;
vector<string> ans;

void b_search(vector<string>& v, string t, int s, int e) {
    int mid = (s+e)/2;

    if(s>e){
        return;
    }

    if(v[mid].compare(t) == 0) {
        ans.push_back(t);
    }

    if(v[mid] > t) b_search(v, t, s, mid-1);
    else if(v[mid] < t) b_search(v, t, mid+1, e);


}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N, M;
    cin >> N >> M;

    vector<string> v1;
    vector<string> v2;

    //듣
    for(int i=0; i<N; ++i) {
        string tmp;
        cin >> tmp;
        v1.push_back(tmp);
    }

    //보
    for(int i=0; i<M; ++i) {
        string tmp;
        cin >> tmp;
        v2.push_back(tmp);
    }

    sort(v1.begin(), v1.end());
    sort(v2.begin(), v2.end());


    for(int i=0; i<M; ++i) {
        b_search(v1, v2[i], 0, v1.size());
    }

    cout << ans.size() << '\n';
    for(int i=0; i<ans.size(); ++i)
        cout << ans[i] << '\n';

    return 0;
}