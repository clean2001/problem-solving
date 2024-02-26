#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(pair<int, int>a, pair<int, int>b) {
	if (a.second == b.second)  return a.first < b.first; //���� ����ð��� ������ ���۽ð��� ������ �տ� ��?
	return a.second < b.second; //second�� �� ȸ�� ���Ḧ �������� �������� ����
}

int main(void)
{
	int N;

	vector<pair<int, int>> conference;
	
	cin >> N;

	int start, end;
	
	for (int i = 0; i < N; i++)
	{
		cin >> start >> end;
		conference.push_back(make_pair(start, end));
	}

	sort(conference.begin(), conference.end(), compare); //�������� ����
	/*����. pair ���� �׳� ���� ����
	sort(v.begin(), v.end()) // ��������
	sort(v.begin(), v.end(), less<>()); // ��������
	sort(v.begin(), v.end(), greater()); //��������
	*/

	int ans = 1; //ù��° ȸ�Ǹ� ����. ��� �׻� ���ð����ϴ�.
	int j = 0;
	for (int i = 1; i < N; i++)
	{
		if (conference[i].first >= conference[j].second) //����! ���� ȸ�ǰ� ������ ���� �ٷ� ���� �����ϹǷ� >= �̴�
		{
			j = i;
			ans++; //i��° ȸ�Ǹ� ����
		}
			
	}

	cout << ans << endl;
	return 0;
}