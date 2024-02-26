#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(pair<int, int>a, pair<int, int>b) {
	if (a.second == b.second)  return a.first < b.first; //만약 종료시간이 같으면 시작시간이 빠른걸 앞에 둠?
	return a.second < b.second; //second값 즉 회의 종료를 기준으로 오름차순 정렬
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

	sort(conference.begin(), conference.end(), compare); //오름차순 정렬
	/*참고. pair 말고 그냥 벡터 정렬
	sort(v.begin(), v.end()) // 오름차순
	sort(v.begin(), v.end(), less<>()); // 오름차순
	sort(v.begin(), v.end(), greater()); //내림차순
	*/

	int ans = 1; //첫번째 회의를 선택. 얘는 항상 선택가능하다.
	int j = 0;
	for (int i = 1; i < N; i++)
	{
		if (conference[i].first >= conference[j].second) //주의! 이전 회의가 끝나자 마자 바로 시작 가능하므로 >= 이다
		{
			j = i;
			ans++; //i번째 회의를 선택
		}
			
	}

	cout << ans << endl;
	return 0;
}