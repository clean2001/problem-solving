#include <iostream>
#include <algorithm>
#include <vector>
#define ll long long
using namespace std;

const ll INF = 1e10;

class segment_tree {
    private:
        vector<ll> tree_min;
        vector<ll> tree_max;

    
    public:
        segment_tree(int N) {
            tree_min.resize(4*N, INF);
            tree_max.resize(4*N, -1);
        }

        //node: tree에서의 인덱스 값 
        void init(int start, int end, int node, vector<ll>& v) {
            int mid = (start + end) / 2;
            if(start == end) {
                tree_min[node] = v[start];
                tree_max[node] = v[start];
                return;
            } else {
                init(start, mid, node*2, v);
                init(mid+1, end, node*2 + 1, v);
                tree_min[node] = min(tree_min[node*2], tree_min[node*2+1]);
                tree_max[node] = max(tree_max[node*2], tree_max[node*2+1]);
            }
        }

        void update(int start, int end, int node, int idx, ll val) {
            int mid = (start + end) / 2;
            if(idx < start || idx > end) {
                return;
            } else if(start == end){
                tree_min[node] = val;
                tree_max[node] = val;
            } else {
                update(start, mid, node*2, idx, val);
                update(mid+1, end, node*2 + 1,idx, val);
                tree_min[node] = min(tree_min[node*2] , tree_min[node*2+1]);
                tree_max[node] = max(tree_max[node*2] , tree_max[node*2+1]);
            }
        }

        //l번째 node에서 r번째 노드까지 쿼리를 수행
        ll query_min(int start, int end, int node, int left, int right) {
            int mid = (start+ end) /2;
            if(start>right || end <left) {
                return INF;
            } else if(start >= left && end <= right) {
                return tree_min[node];
            } else {
                return min(query_min(start, mid, node*2, left, right), query_min(mid+1, end, node*2+1, left, right));
            }
        } //pair로 한 배열에 min/max 같이 저장하면 쿼리 배열 하나만 있어도 됨.

        ll query_max(int start, int end, int node, int left, int right) {
            int mid = (start+ end) /2;
            if(start>right || end <left) {
                return -1;
            } else if(start >= left && end <= right) {
                return tree_max[node];
            } else {
                return max(query_max(start, mid, node*2, left, right), query_max(mid+1, end, node*2+1, left, right));
            }
        }
};

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    
    int N, M;
    ll minVal, maxVal;

    cin >> N >> M;

    vector<ll> A(N+1);
    for(int i=1; i<=N; ++i) {
        cin >> A[i];
    }

    segment_tree tree(N);
    tree.init(1, N, 1, A);

    for(int i=0; i<M; ++i) {
        int a, b;
        cin >> a >> b;

        //tree.update(1,N,1,a,b);
        minVal = tree.query_min(1, N, 1, a, b);
        maxVal = tree.query_max(1, N, 1, a, b);

        cout << minVal << ' ' << maxVal << '\n'; 
    }

    return 0;
}