#include <iostream>
#include <algorithm>
#include <vector>
#include <map>
using namespace std;

#define ll long long

class segment_tree {
    private:
        vector<ll> tree;

    public:
        segment_tree(int N) {
            tree.resize(4*N);
        }

    //node:tree에서의 인덱스 값
        void init(int start, int end, int node, vector<ll>& v) {
            int mid = (start + end) / 2;
            if(start == end) {
                tree[node] = v[start];
                return; 
            } else {
                init(start, mid, node*2, v);
                init(mid+1, end, node*2+1, v);
                tree[node] = tree[node*2] + tree[node*2 + 1];
            }
        }

        void update(int start, int end, int node, int idx, ll val) {
            int mid = (start + end) / 2;
            if(idx < start || idx > end)
                return;
            else if(start == end) {
                tree[node] = val;
            } else {
                update(start, mid, node*2, idx, val);
                update(mid+1, end, node*2+1, idx, val);
                tree[node] = tree[node*2] + tree[node*2+1];
            }
        }


        ll query(int start, int end, int node, int left, int right) {
            int mid = (start + end) / 2;
            if(start > right || end < left)
                return 0;
            else if(start >= left && end <= right)
                return tree[node];
            else
                return query(start, mid, node*2, left, right) + query(mid+1, end, node*2+1, left, right);
        }

};

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    ll N;
    ll tmp;

    cin >> N;
    map<ll, ll> m;
    //int v2[500001];

    vector<ll> v(N+1,0);
    for(ll i=1; i<=N; ++i) {
        cin >> tmp;
        m.insert(pair<ll, ll>(tmp, i));
    }
    segment_tree tree = segment_tree(N);
    tree.init(1, N, 1, v);

    ll ans = 0;
    for(int i=1; i<=N; ++i) {
        cin >> tmp;
        int idx = m[tmp];
        //printf("idx: %d\n", idx);

        ans += tree.query(1, N,1 , idx, N);
        tree.update(1, N, 1, idx, 1);
    }

    cout << ans << '\n';
    return 0;
}