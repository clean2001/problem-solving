#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

vector <int> LIS;
int main()
{
    int N;
    while(cin>>N)
    {
        for(int j=0; j<N; j++)
        {
            int tmp;

            cin >> tmp;
            
            int idx = lower_bound(LIS.begin(), LIS.end(), tmp) - LIS.begin();

            if(idx == LIS.size())
                LIS.push_back(tmp);
            else
                LIS[idx] = tmp;
        }

        cout << LIS.size() << endl;

            LIS.clear();
    }

    

    return 0;
}