#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <map>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int T;
	cin >> T;
	for (int tc = 0; tc < T; ++tc)
	{
		priority_queue<int> maxHeap;
		priority_queue<int, vector<int>, greater<int>> minHeap;
		map<int, int> m;
		int Q;
		cin >> Q;

		int v = 0;
		for (int i = 0; i < Q; ++i)
		{

			char C;
			int N;
			cin >> C >> N;
			switch (C)
			{
			case 'I':
				maxHeap.push(N);
				minHeap.push(N);
				m[N]++;
				break;
			case 'D':
				if (N == 1)
				{
					while (!maxHeap.empty())
					{
						int key = maxHeap.top();
						if (!m[key])
						{
							maxHeap.pop();
						}
						else
						{
							// cout << "max: " << key << '\n';
							maxHeap.pop();
							m[key]--;
							break;
						}
					}
				}
				else if (N == -1)
				{
					while (!minHeap.empty())
					{
						int key = minHeap.top();
						if (!m[key])
						{
							minHeap.pop();
						}
						else
						{
							// cout << "min: " << key << '\n';
							minHeap.pop();
							m[key]--;
							break;
						}
					}
					// cout << "EMPTY\n";
				}
				break;
			}
		}

		while (!maxHeap.empty() && m[maxHeap.top()] == 0)
			maxHeap.pop();
		while (!minHeap.empty() && m[minHeap.top()] == 0)
			minHeap.pop();
		if (maxHeap.empty() || minHeap.empty())
		{
			cout << "EMPTY\n";
		}
		else
		{
			cout << maxHeap.top() << ' ' << minHeap.top() << '\n';
		}
	}

	return 0;
}