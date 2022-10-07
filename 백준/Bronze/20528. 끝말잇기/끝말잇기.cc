#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;
	string s;
	cin >> s;
	char c = s[0];

	int is_ok = 1;
	for(int i=1; i<N; ++i) {
		cin >> s;
		if(s[0] != c) is_ok = 0;
	}

	cout << is_ok << '\n';

	return 0;
}