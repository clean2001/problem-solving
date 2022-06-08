#include <iostream>
#include <algorithm>
using namespace std;

int fibo(int n) {
    if(n==0)
        return 1;
    else
        return fibo(n-1) * n;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int N;

    cin >> N;

    cout << fibo(N) << '\n';
    return 0;
}