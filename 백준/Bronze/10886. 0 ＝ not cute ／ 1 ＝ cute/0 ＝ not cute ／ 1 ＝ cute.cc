#include <iostream>
#include <vector>
using namespace std;
int main()
{
	int N;
	int notCute = 0, cute = 0;
	cin >> N;

	vector<int> vote;

	for (int i = 0; i < N; i++)
	{
		int tmp;
		cin >> tmp;
		vote.push_back(tmp);

		if (vote[i] == 0)
			notCute++;
		else
			cute++;

	}

	if (cute > notCute)
		printf("Junhee is cute!\n");
	else
		printf("Junhee is not cute!\n");

	return 0;
}
