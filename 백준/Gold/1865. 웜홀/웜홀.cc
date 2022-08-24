#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int N, M, W;

vector<pair<int, int>> edges[501];

const int INF = 1e9;
int dist[501];

bool bf(int start) {
	dist[start] = 0;

	for(int k=0; k<N; ++k) {
		for(int i=1; i<=N; ++i) {
			for(pair<int, int> ed : edges[i]) {
				if(dist[ed.first] > dist[i] + ed.second) {
					dist[ed.first] = dist[i] + ed.second;

					if(k == N-1) return true;
				}
			}
		}
	}

	return false;

}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int T;
	cin >> T;
	for(int tc = 0; tc < T; ++tc) {

		fill(dist, dist+501, INF);
		for(int i=0; i<501; ++i) edges[i].clear();

		cin >> N >> M >> W;

		for(int i=0; i<M; ++i) {
			int s, e, t;
			cin >> s >> e >> t;
			
			edges[s].push_back({e, t});
			edges[e].push_back({s, t});
		}

		for(int i=0; i<W; ++i) {
			int s, e, t;
			cin >> s >> e >> t;
			edges[s].push_back({e, -t});
		}

		bool is_negative = bf(1);

		if(is_negative) {
			cout << "YES\n";
		} else {
			cout << "NO\n";
		}
	}

	
	return 0;
}