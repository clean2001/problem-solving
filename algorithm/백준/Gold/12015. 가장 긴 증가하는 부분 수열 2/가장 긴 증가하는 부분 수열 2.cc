#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> input;
vector<int> LIS;
int main()
{
	int N;
	cin >> N;


	for (int i = 0; i < N; i++)
	{
		int tmp;
		cin >> tmp;
		input.push_back(tmp);
	}

	//sort(input.begin(), input.end());

	for (int i = 0; i < N; i++)
	{
		//iterator는 포인터랑 비슷. iterator는 클래스로 구현되어있음.
		int idx = lower_bound(LIS.begin(), LIS.end(), input[i]) - LIS.begin(); //포인터끼리 연산

		if (idx == LIS.size())
			LIS.push_back(input[i]);
		else
			LIS[idx] = input[i];
	}

	cout << LIS.size() << endl;

	return 0;
}
