#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
vector<long long> v;

int canMake(vector<long long>& v, int K, int N, long long mid)
{
	int cnt = 0;
	for (int i = 0; i < K; i++)
		cnt += v[i] / mid;

	if (cnt >= N)
		return 1;
	else
		return 0;
}

long long parametic_search(vector<long long>& v, int K, int N)
{
	int max = *max_element(v.begin(), v.end());

	long long left = 0, right =max;

	while (left < right)
	{
		long long mid = (left + right + 1) / 2;

		if (canMake(v, K, N, mid)==1)
			left = mid;
		else
			right = mid - 1;
	}

	return left;
}

int main()
{
	int K, N;

	cin >> K >> N;

	for (int i = 0; i < K; i++)
	{
		int tmp;
		cin >> tmp;
		v.push_back(tmp);
	}

	

	cout << parametic_search(v, K, N) << endl;

	return 0;
}

