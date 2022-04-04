#include <iostream>
#include <algorithm>
using namespace std;

int L[21], J[21]; //0번째 인덱스 안씀..???
int dp[21][101];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    
    int N; //사람 수
    //int HP = 99, delight = 0; //초기 체력 ,기쁨
    int rslt = 0;

    cin >> N;

    for(int i=1 ;i<=N; ++i)
        cin >> L[i]; //잃는 체력 입력
    
    for(int i=1; i<=N; ++i)
        cin >> J[i]; //얻는 기쁨 입력

    
    for(int k=1; k<=N; ++k)
    {
        for(int h=100; h>0; --h)
        {
            if(h - L[k] > 0 ) //인사 할 수 있음
                dp[k][h] = max(dp[k-1][h], dp[k-1][h-L[k]] + J[k]);
            else //인사 할 수 없음
                dp[k][h] = dp[k-1][h];

            //rslt = max(dp[k][h], rslt);

        }
    }

    cout << dp[N][100] << "\n";

    return 0;

}