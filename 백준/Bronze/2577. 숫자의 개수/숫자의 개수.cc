#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
    int n1, n2, n3;
    int mul;
    int digit[10] = {0};
    
    cin >> n1 >> n2 >> n3;
    mul = n1 * n2 * n3;
    
    for(; mul>0; mul /= 10) {
        digit[mul % 10]++;
    }
    

    for(int num : digit) {
        cout << num <<'\n';
    }

    return 0;
}