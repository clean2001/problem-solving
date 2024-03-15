// 14500. 테트로미노
import java.io.*;
import java.util.*;

class B14500 {
    static int N, M;
    static int[][] map;
    static boolean[][] vis;

    static int ans = 0;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        vis = new boolean[N][M];

        for(int i=0; i<N; ++i) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; ++i) {
            for(int j=0; j<M; ++j) {
                vis[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                vis[i][j] = false;
            }
        }


        System.out.println(ans);
    }


    private static void dfs(int y, int x, int cnt, int sum) {
        if (cnt >= 4) {
            ans = Math.max(sum, ans);
            return;
        }

        for(int i=0; i<4; ++i) {

            int ny = y + dy[i];
            int nx = x + dx[i];

            if(!is_safe(ny, nx)) continue;
            if(vis[ny][nx]) continue;

            // ㅜ 처리 => y, x에서 탐색 한번 더 진행
            if(cnt == 2) {
                vis[ny][nx] = true;
                dfs(y, x, cnt+1, sum+map[ny][nx]);
                vis[ny][nx] = false;
            }

            vis[ny][nx] = true;
            dfs(ny, nx, cnt+1, sum+map[ny][nx]);
            vis[ny][nx] = false;
        }

    }

    private static boolean is_safe(int y, int x) {
        return y>=0 && y<N && x>=0 && x<M;
    }

}