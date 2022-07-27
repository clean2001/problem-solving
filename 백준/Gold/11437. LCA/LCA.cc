#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int parent[50001];
int depth[50001];

vector<int> adj[50001];

void set_tree(int c, int p) {
	parent[c] = p;
	depth[c] = depth[p] + 1;

	for(int child : adj[c]) {
		if(child == p) continue;

		set_tree(child, c);
	}
}

int LCA(int a, int b) {
	if(depth[a] > depth[b]) {
		for(; depth[a] > depth[b]; a = parent[a]);
	} else if(depth[a] < depth[b]) {
		for(; depth[a] < depth[b]; b = parent[b]);
	}

	while(a!=b) {
		a = parent[a];
		b = parent[b];
	}

	return a;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;

	for(int i=0; i<N-1; ++i) {
		int a, b;
		cin >> a >> b;
		adj[a].push_back(b);
		adj[b].push_back(a);
	}

	set_tree(1, 0);

	int M;
	cin >> M;
	for(int i=0; i<M; ++i) {
		int n1, n2;
		cin >> n1 >> n2;
		cout << LCA(n1, n2) << '\n';

	}

	
	return 0;
}