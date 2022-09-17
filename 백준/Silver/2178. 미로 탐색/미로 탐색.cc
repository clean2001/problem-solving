#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <cstdio>

#define INF 987654321
using namespace std;

int N, M;

int dist[101][101] = {INF};
int maze[101][101];

int dy[4] = {0, 1, 0, -1};
int dx[4] = {1, 0, -1, 0};


void BFS();

int main()
{
    /*ios_base::sync_with_stdio(false);
    cin.tie(0);*/

    cin >> N >> M;

    for(int i=1; i<=N; i++)
    {
        for(int j=1; j<=M; j++)
        {
            scanf("%1d", &maze[i][j]);
        }
    }

    BFS();
    
}

void BFS() {
    for(int i=0; i< 101; ++i)
        fill(dist[i], dist[i]+101, INF);

        queue<pair<int, int>>  q;
        dist[1][1] = 1;

        q.push({1, 1});

        while(!q.empty()) {
            int y = q.front().first;
            int x = q.front().second;
            q.pop();

            for(int i=0; i<4; ++i)
            {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(nx <= 0 || nx >M || ny > N) continue;
                if(maze[ny][nx] == 0) continue;
                if(dist[ny][nx] <= dist[y][x] + 1) continue;

                dist[ny][nx] = dist[y][x] + 1;
                q.push({ny, nx});
            }
            
        }

        cout << dist[N][M] << '\n';
}