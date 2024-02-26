#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int N;
    int scores[1001];
    int max = -1;

    cin >> N;

    for(int i=0; i<N; i++) {
        cin >> scores[i];

        if(scores[i] > max)
            max = scores[i];
    }

    double total = 0;
    for(int i=0; i<N; i++) {
        total += (double)((scores[i] / (double)max) * 100.0);
    }

    cout << (total /(double) N) << '\n';
    return 0;
}