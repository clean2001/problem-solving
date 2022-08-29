#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int map[51][51];

int N, M;

bool is_safe(int r, int c) {
    return (r>=0 && r<N && c>=0 && c<M);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N >> M;
    int r, c, d;
    cin >> r >> c >> d; // d: 0=북, 1=동, 2=남, 3=서

    int dr[4], dc[4];

    for(int i=0; i<N; ++i) {
        for(int j=0; j<M; ++j) {
            cin >> map[i][j];
        }
    }

    int ans = 0;
    while(is_safe(r, c) && map[r][c] != 1) {
        // if(r == 8 && c == 2) cout << "8, 2, d: " << d << '\n';

        // if(r == 7 && c == 2) cout << "7, 2, d: " << d << '\n';
        if(d == 0) {
            dr[0] = 0; dr[1] = 1; dr[2] = 0; dr[3] = -1;
            dc[0] = -1; dc[1] = 0; dc[2] = 1; dc[3] = 0;
        } else if(d == 1) {
            dr[0] = -1; dr[1] = 0; dr[2] = 1; dr[3] = 0;
            dc[0] = 0; dc[1] = -1; dc[2] = 0; dc[3] = 1;
        } else if(d == 2) {
            dr[0] = 0; dr[1] = -1; dr[2] = 0; dr[3] = 1;
            dc[0] = 1; dc[1] = 0; dc[2] = -1; dc[3] = 0;
        } else {
            dr[0] = 1; dr[1] = 0; dr[2] = -1; dr[3] = 0;
            dc[0] = 0; dc[1] = 1; dc[2] = 0; dc[3] = -1;
        }


        if(map[r][c] == 0) {
            ans++;
            map[r][c] = 2;
        }


        int i = 0;

        for(i=0; i<4; ++i) {
            if(is_safe(r+dr[i], c+dc[i]) && map[r+dr[i]][c+dc[i]] == 0) {
                r += dr[i]; c += dc[i];
                d = (d + 8 - i-1) % 4;

                //cout << "~!\n";
                break;
            }
        }

        if(i == 4) {
            // d = origin_d;
            r += dr[1]; c+= dc[1];
        }

    }

    cout << ans << '\n';
    return 0;
}