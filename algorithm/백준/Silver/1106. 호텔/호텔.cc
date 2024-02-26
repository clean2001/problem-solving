#include <iostream>
#include <algorithm>
//#include <vector>
using namespace std;

int cost[21];
int customer[21];

int dp[101][100001];

//vector<int> dp;
int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int N, C; //N은 홍보할 수 있는 도시 개수, C는 적어도 늘려야되는 고객수
    int rslt = 987654321;

    cin >> C >> N;

    for(int i=1; i<=N; i++)
        cin >> cost[i] >> customer[i];
    
    for(int k=1; k<=N; ++k)
    {
        for(int c=1; c<=100000; ++c) //비용이 1부터 100000까지 돎
        {
            if(c-cost[k] >= 0)
                dp[k][c] = max(dp[k-1][c], dp[k][c-cost[k]]+customer[k]);
            else
                dp[k][c] = dp[k-1][c];

            if(dp[k][c] >= C)
                 rslt = min(rslt, c);
        }
    }

    cout<<rslt<<"\n";

    return 0;
}