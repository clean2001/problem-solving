#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int main()
{
	int dp[1001][3]; //메모이제이션, 행을 1001개 선언한 이유: i번째 집의 정보를 i번째 행에 넣기 위함.
	//int paint[1001][3]; //비용을 저장

	//for (int i = 0; i < 1001; ++i)
	//	fill(dp[i], dp[i] + 3, -1); //메모이제이션 배열 초기화

	int N;
	cin >> N;

	dp[0][0] = 0; dp[0][1] = 0; dp[0][2] = 0;

	for (int i = 1; i <= N; i++)
	{
		int r, g, b;
		cin >> r >> g >> b;

		dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + r;
		dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + g;
		dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + b;
		
	} //0 -r, 1-g, 2-b. 비용저장

	//cout << min({cost(N,0), cost(N,1), cost(N,2) });

	//Bottom up
	
	/*for (int i =1; i <= N; i++)
	{
		dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + paint[i][0];
		dp[i][1] = min(dp[i - 1][2], dp[i - 1][0]) + paint[i][1];
		dp[i][2] = min(dp[i - 1][2], dp[i - 1][1]) + paint[i][2];
	}*/

	int ans = min({ dp[N][0], dp[N][1], dp[N][2] }); //질문 {}쳐야하는 이유: 배열인자 넘긴거임

	cout << ans << endl;

	return 0;
}