//백준 15686 치킨거리
#include <iostream>
#include <vector>
#include <cstdlib>
#include <algorithm>


#define MAX 50
#define chickenMax 13

using namespace std;

int Town[MAX][MAX];
vector<pair<int, int>> house;
vector<pair<int, int>> chicken;

bool chickenSelect[chickenMax] = { false }; //선택이 되었는지, 아닌지를 표시하는 배열
int sum = 0;
int minSum = 987654321;

int Distance(pair <int, int> x, pair<int, int> y) //치킨거리를 구해주는 함수. 집 개수(house.size()) * 치킨집 수(M) 만큼 distance()호출
{

	return (abs(x.first - y.first) + abs(x.second - y.second));

}


void DFS(int idx, int cnt, int M) //조합 함수. 폐업시키지 않을 모든 치킨집 경우의 수를 구한다.(M개)
{
	if (cnt == M)
	{
		sum = 0;
		
		
		for (int i = 0; i < house.size(); i++)
		{
			int d = 987654321;
			
			for (int j = 0; j < chicken.size(); j++)
			{
				
				if (chickenSelect[j] == true)
				{
					d = min(d, Distance(house[i], chicken[j]));
				}
			}

			sum += d;
		}
		/*for (int i = 0; i < chicken.size() ; i++)
		{
			if (chickenSelect[i] == true)
			{
				for(int j=0; j < house.size(); j++)
					sum += Distance(chicken[i], house[j]);
			}
		}*/

		if (sum < minSum)
			minSum = sum;

		return;
	}


	
	for (int i = idx; i < chicken.size(); i++)
	{
		if (chickenSelect[i] == true)  continue; //선택이 되어있다면, 다시 위로 올라감

		chickenSelect[i] = true; //선택이 안되어있으면 선택한다.
		
		DFS(i, cnt + 1, M);
		chickenSelect[i] = false;
	}
}

int main()
{
	int N, M; //도시크기 NxN /  M은 폐업시키지 않을 치킨집 수

	cin >> N >> M; //첫째줄 N, M을 입력 받는다

	for(int i=0; i<N; i++) //Town 정보를 입력 받으면서, house(1)과 chicken(2) 정보를 저장
		for (int j = 0; j < N; j++)
		{
			cin >> Town[i][j];

			if(Town[i][j] == 1)
				house.push_back({ i, j });
			else if(Town[i][j]==2)
				chicken.push_back({ i, j });
		}


	
	//DFS로 모든 경우의 수를 구해서 치킨거리 계산 후 최소값 찾기. chicken.size()개 중에서 M개를 뽑는 조합
	DFS(0, 0, M);


	printf("%d\n", minSum);

	return 0;

}