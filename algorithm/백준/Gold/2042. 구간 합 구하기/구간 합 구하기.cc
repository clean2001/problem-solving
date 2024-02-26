#include <iostream>
#include <algorithm>
#include <vector>
#define ll long long
using namespace std;

class segment_tree {
    private:
        vector<ll> tree;
    
    public:
        segment_tree(int N) {
            tree.resize(4*N);
        }

        //node: tree에서의 인덱스 값 
        void init(int start, int end, int node, vector<ll>& v) {
            int mid = (start + end) / 2;
            if(start == end) {
                tree[node] = v[start];
                return;
            } else {
                init(start, mid, node*2, v);
                init(mid+1, end, node*2 + 1, v);
                tree[node] = tree[node*2] + tree[node*2+1];
            }
        }

        void update(int start, int end, int node, int idx, ll val) {
            int mid = (start + end) / 2;
            if(idx < start || idx > end) {
                return;
            } else if(start == end){
                tree[node] = val;
            } else {
                update(start, mid, node*2, idx, val);
                update(mid+1, end, node*2 + 1,idx, val);
                tree[node] = tree[node*2] + tree[node*2+1];
            }
        }

        //l번째 node에서 r번째 노드까지 쿼리를 수행
        ll query(int start, int end, int node, int left, int right) {
            int mid = (start+ end) /2;
            if(start>right || end <left) {
                return 0;
            } else if(start >= left && end <= right) {
                return tree[node];
            } else {
                return query(start, mid, node*2, left, right) + query(mid+1, end, node*2+1, left, right);
            }
        }
};

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);

    int N, M, K; cin >> N >> M >>K;
    vector<ll> A(N+1);
    for(int i=1; i<=N; ++i) cin >> A[i];

    segment_tree tree(N);
    tree.init(1, N, 1, A);

    for(int i=0; i<M+K; ++i) {
        ll a,b,c; cin >> a >> b >> c;
        if(a==1) tree.update(1, N, 1, b, c);
        else cout << tree.query(1, N, 1, b ,c) << '\n';
    }

    return 0;
}