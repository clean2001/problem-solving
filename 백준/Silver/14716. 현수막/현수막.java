import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
  static int N, M;
  static int[][] map;
  static int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};
  static int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    for(int i=0; i<N; ++i) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int ans = 0;
    boolean[][] vis = new boolean[N][M];
    for(int i=0; i<N; ++i) {
      for(int j=0; j<M; ++j) {
        if(vis[i][j] || map[i][j] == 0) continue;

        ans++;
        dfs(i, j, vis);
      }
    }

    System.out.println(ans);

  }

  private static void dfs(int y, int x, boolean[][] vis) {
    vis[y][x] = true;

    for(int i=0; i<8; ++i) {
      int ny = y + dy[i];
      int nx = x + dx[i];

      if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
      if(vis[ny][nx]) continue;
      if(map[ny][nx] == 0) continue;

      dfs(ny, nx, vis);
    }
  }
}