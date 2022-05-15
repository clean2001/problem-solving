#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#define INF 987654321
using namespace std;

int dy[4] = {0, 1, 0, -1};
int dx[4] = {1, 0, -1, 0};
int M, N, K;
int cnt = 0;

bool visit[50][50];
int field[50][50];

void BFS(int sY, int sX)
{
    queue<pair<int, int>> q;

    visit[sY][sX] = true;
    q.push({sY,sX});

    while(!q.empty()) {
        int y = q.front().first;
        int x = q.front().second;
        q.pop();

        for(int i=0; i<4; ++i)
        {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
            if(field[ny][nx] == 0) continue;
            if(visit[ny][nx]) continue;

            visit[ny][nx] = true;
            q.push({ny, nx});
            
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int T;
    int X, Y;
    int sX, sY;

    cin >> T;

    for(int i=0; i<T; i++)
    {
        int cnt = 0;
        cin >> M >> N >> K;

        for(int j=0; j<50; j++)
        {
            fill(visit[j], visit[j] + 50, false);
            fill(field[j], field[j] + 50, 0);
        }

        //cin >> sX >> sY;
        //field[sX][sY] = 1;
        for(int j=0; j<K; j++)
        {
            cin >> X >> Y;
            field[Y][X] = 1;
        }

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                if(field[i][j] == 1 && visit[i][j] == 0)
                {
                    BFS(i, j);
                    cnt++;
                }
            }
        }

        cout << cnt << '\n';
    }
    
    return 0;
}