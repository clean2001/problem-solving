#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int arr[200001];

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N, Q;
	cin >> N >> Q;

	for(int i=0; i<N; ++i) {
		cin >> arr[i];
	}

	int start = 0, end = N-1;
	for(int i=0; i<Q; ++i) {
		int c;
		cin >> c;

		int s;
		switch(c) {
		case 1:
			int k, x;
			cin >> k >> x;
			arr[(k-1 + start) % N] += x;
			break;
		case 2:
			cin >> s;
			start = (start + N - s) % N;
			end = (end +N - s) % N;
			break;
		case 3:
			cin >> s;
			start = (start + s ) % N;
			end = (end + s) % N;
			break;
		}
	}

	for(int i = 0; i<N; ++i) {
		cout << arr[(i+start)%N] << ' ';
	}

	cout << '\n';

	return 0;
}