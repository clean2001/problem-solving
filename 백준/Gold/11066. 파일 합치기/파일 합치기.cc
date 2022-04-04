#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

int dp[501][501]; //fill은 보통 일차원 배열에서만 됨 memset -> cstring헤더
// fill 은 모든 값으로 초기화 가능, memset은 0, -1
int sum[501];
int files[501];

int sol(int l, int r)
{
    int& ret = dp[l][r];

    if(ret != -1) return ret;
    if(l==r) return ret = 0;

    ret = 1e9;

    for(int k=l; k<r; k++)
        ret = min(sol(l,k) + sol(k+1, r) + sum[r]-sum[l-1], ret);

    return ret;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int T, K;

    cin >> T;

    for(int i=0; i<T; i++)
    {      
        memset(dp, -1, sizeof(dp));


        cin >> K;

        for(int j=1; j<=K; j++)
        {
            files[j] = 0;
            sum[j] = 0;
        }
        for(int j=1; j<=K; j++)
            cin >> files[j];

        //sum 누적합 prefix어쩌구
        for(int j=1; j<=K; j++)
        {
            if(j==1)
                sum[j] = files[j];
            else
                sum[j] = sum[j-1] + files[j];
        }

        cout << sol(1, K) <<"\n";
    }

    return 0;
}