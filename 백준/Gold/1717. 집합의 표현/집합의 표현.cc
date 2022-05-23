#include <iostream>
#include <algorithm>
using namespace std;

int parent[1000002];


int Find(int node) {
    if(parent[node] == node)
        return node;
    else
        return parent[node] = Find(parent[node]);
}

void Union(int a, int b) {
    int r1 = Find(a);
    int r2 = Find(b);

    r2[parent] = r1;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    
    int n, m;

    cin >> n >> m;

    for(int i=0; i<=n; ++i) {
        parent[i] = i;
    }

    for(int i=0; i<m; ++i)
    {
        int choice, a, b;

        cin >> choice >> a >> b;

        switch(choice) {
            case 0: //union
                Union(a,b);
                break;

            case 1: //find
                if(Find(a) == Find(b))
                    cout << "YES\n";
                else
                    cout << "NO\n";
                break;
        }
    }
    
}
