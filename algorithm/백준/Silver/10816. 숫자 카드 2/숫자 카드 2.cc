#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
vector<int> cards;
vector<int> s;
vector<int> sNum;
int cnt = 0;

int main()
{
    ios::sync_with_stdio(false);
	cin.tie(NULL);

    int N;

    cin >>N;

    

    for(int i=0; i<N ;i++)
    {
        int tmp;
        cin >> tmp;
        s.push_back(tmp);
    }

    int M;
    cin >> M;

    
    for(int i=0; i<M;i++)
    {
        int tmp;
        cin >> tmp;
        cards.push_back(tmp);
    }

    sort(s.begin(), s.end());

    for(int i=0; i<cards.size(); ++i)
    {
        int cnt = upper_bound(s.begin(), s.end(), cards[i]) - lower_bound(s.begin(), s.end(), cards[i]);
        cout << cnt << " ";
    }
    cout<<"\n";

    return 0;
}