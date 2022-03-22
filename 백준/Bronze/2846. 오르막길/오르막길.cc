#include <iostream>
#include <vector>
using namespace std;
int main()
{
	int N;
	cin >> N;

	vector<int> land;

	int height = 0, maxHeight = 0, start = 0;

	for (int i = 0; i < N; i++)
	{
		int tmp;
		cin >> tmp;

		land.push_back(tmp);

	}

	for (int i =1; i < N; i++)
	{
		if (land[i] <= land[i - 1])
		{
			height = land[i -1] - land[start];

			if (height > maxHeight)
				maxHeight = height;

			height = 0;
			start = i;
		}
	}

	if (land[N - 1] >= land[N - 2])
		height = land[N - 1] - land[start];

	if (height > maxHeight)
		maxHeight = height;

	cout << maxHeight << endl;

	return 0;
}