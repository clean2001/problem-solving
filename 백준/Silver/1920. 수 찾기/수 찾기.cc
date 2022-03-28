#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int binary_search(vector<int>& v, int value)
{
	int left = 0;
	int right = v.size() - 1;

	while (left <= right)
	{
		int mid = (left + right) / 2;
		
		if (v[mid] == value)
			return mid;
		else if (v[mid] > value)
			right = mid - 1;
		else
			left = mid + 1;
	}

	return -1;
}
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	int N, M;

	cin >> N;

	vector<int> v(N, 0);

	for (int i = 0; i < N; i++)
	{
		int tmp;
		cin >> v[i];
	}

	sort(v.begin(), v.end());

	cin >> M;
	for (int i = 0; i < M; i++)
	{
		int tmp;
		cin >> tmp;

		int in = binary_search(v, tmp);

		if (in == -1)
			cout << "0\n";
		else
			cout << "1\n";
		
	}

	return 0;

}