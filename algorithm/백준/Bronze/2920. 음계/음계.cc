#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int a, b;
    int c = 0;
    cin >> a >> b;
    c = b-a;
    a = b;

    for(int i=2; i<8; i++) {
        cin >> b;

        if(c != b-a) {
            cout << "mixed";
            return 0;
        }
        a = b;
    }

    if(c > 0) cout << "ascending\n";
    else cout << "descending\n";

    return 0; 
}