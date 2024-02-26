//���� 15686 ġŲ�Ÿ�
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

bool chickenSelect[chickenMax] = { false }; //������ �Ǿ�����, �ƴ����� ǥ���ϴ� �迭
int sum = 0;
int minSum = 987654321;

int Distance(pair <int, int> x, pair<int, int> y) //ġŲ�Ÿ��� �����ִ� �Լ�. �� ����(house.size()) * ġŲ�� ��(M) ��ŭ distance()ȣ��
{

	return (abs(x.first - y.first) + abs(x.second - y.second));

}


void DFS(int idx, int cnt, int M) //���� �Լ�. �����Ű�� ���� ��� ġŲ�� ����� ���� ���Ѵ�.(M��)
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
		if (chickenSelect[i] == true)  continue; //������ �Ǿ��ִٸ�, �ٽ� ���� �ö�

		chickenSelect[i] = true; //������ �ȵǾ������� �����Ѵ�.
		
		DFS(i, cnt + 1, M);
		chickenSelect[i] = false;
	}
}

int main()
{
	int N, M; //����ũ�� NxN /  M�� �����Ű�� ���� ġŲ�� ��

	cin >> N >> M; //ù°�� N, M�� �Է� �޴´�

	for(int i=0; i<N; i++) //Town ������ �Է� �����鼭, house(1)�� chicken(2) ������ ����
		for (int j = 0; j < N; j++)
		{
			cin >> Town[i][j];

			if(Town[i][j] == 1)
				house.push_back({ i, j });
			else if(Town[i][j]==2)
				chicken.push_back({ i, j });
		}


	
	//DFS�� ��� ����� ���� ���ؼ� ġŲ�Ÿ� ��� �� �ּҰ� ã��. chicken.size()�� �߿��� M���� �̴� ����
	DFS(0, 0, M);


	printf("%d\n", minSum);

	return 0;

}