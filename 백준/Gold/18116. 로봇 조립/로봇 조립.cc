#include <iostream>
#include <algorithm>
using namespace std;

int cnt = 0;
int parent[1000001];
int group_size[1000001];

int Find(int node) {
    if(parent[node] == node)
        return node;
    else
        return parent[node] = Find(parent[node]);
}

void Union(int a, int b) {
    int r1 = Find(a);
    int r2 = Find(b);

    if(r1 != r2) {
        parent[r2] = r1;
        group_size[r1] = group_size[r2] + group_size[r1];
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int N;
    cin >> N;

    for(int i=1; i<=1000000; i++) {
        parent[i] = i;
        group_size[i] = 1;
    }

    char c;
    int a, b;

    for(int i=0; i<N; i++)
    {
        cin >> c;
        switch(c) {
            case 'I':
                cin >> a >>b;
                Union(a, b);
                break;
            case 'Q' :
                cin >> a;
                int num;
                cnt = 0;
                cout << group_size[Find(a)] << '\n';
        }
    }

    return 0;
}