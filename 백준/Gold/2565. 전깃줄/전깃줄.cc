#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

bool compare(pair<int, int> a , pair<int, int> b) {
	return a.first < b.first;
}

vector<pair<int, int>> v;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;

	for(int i=0; i<N; ++i) {
		int a, b;
		cin >> a >> b;
		v.push_back({a, b});
	}

	sort(v.begin(), v.end(), compare);

	// vector<int> tmp;
	// for(pair<int, int> p : v) tmp.push_back(p.second);

	/*LIS*/
	vector<int> LIS;
	for(int i=0; i<N; ++i) {
		auto iter = lower_bound(LIS.begin(), LIS.end(), v[i].second);

		if(iter == LIS.end()) {
			LIS.push_back(v[i].second);
		} else {
			int idx = iter - LIS.begin();
			LIS[idx] = v[i].second;
		}
	}

	cout << N-LIS.size() << '\n';
	
	return 0;
}