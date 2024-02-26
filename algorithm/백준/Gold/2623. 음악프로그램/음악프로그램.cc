#include <iostream>
#include <queue>
using namespace std;
int adj[1001][1001] = {0};
int indegree[1001] = {0};
bool flag[1001] = {false};


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int N, M;
    cin >> N >> M;

    for(int i=1; i<=M; ++i) {
        int num;
        cin >> num;
        vector<int>s(num + 1,0); //여기서 1개 크게 할당해줘야되는데... num개 해줌
        for(int j=1; j<=num; ++j) {
            cin >> s[j];
        }
        for(int j=1; j<num; ++j)
            for(int k=j+1; k<=num; ++k)
                adj[s[j]][s[k]]=1;
    }


    //check indegree
    for(int i=1; i<=N; ++i) {
        for(int j=1; j<=N; ++j) {
            if(adj[j][i] == 1) ++indegree[i];
        }
    }

    //topological sort
    queue<int> q;
    for(int i=1; i<=N; ++i)
        if(indegree[i] == 0){
            q.push(i);
            flag[i] = true;
            break;
        }
    
    vector<int> sort;
    while(!q.empty()) {
        int v = q.front();
        q.pop();
        sort.push_back(v);

        for(int i=1; i<=N; ++i) {
            if(adj[v][i] == 1) indegree[i]--;

            if(indegree[i] == 0 && flag[i]==false) {
                 q.push(i);
                 flag[i] = true;
            }
        }
    }

    if(sort.size() < N) cout << 0 << '\n';
    else {
        for(int v : sort)
            cout << v << '\n';
    }
    return 0;
}