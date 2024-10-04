import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {
  static int N, M;
  static int[] dy = {1, -1, 0, 0};
  static int[] dx = {0, 0, 1, -1};
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String s = br.readLine();
    StringTokenizer st = new StringTokenizer(s);

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    int[][] map = new int[N][M];
    boolean[][] vis = new boolean[N][M];

    for(int i=0; i<N; ++i) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int cnt = 0;
    int ans = 0;
    for(int i=0; i<N; ++i) {
      for(int j=0; j<M; ++j) {
        if(map[i][j] == 0 || vis[i][j]) continue;
        int tmp = bfs(i, j, vis, map);

        cnt++;
        ans = Math.max(ans, tmp);
      }
    }

    System.out.println(cnt);
    System.out.println(ans);

  }

  private static int bfs(int y, int x, boolean[][] vis, int[][] map) {
    int ret = 0;
    vis[y][x] = true;
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{y, x});
    while(!q.isEmpty()) {
      ret++;
      int[] cur = q.poll();
      for(int i=0; i<4; ++i) {
        int ny = cur[0] + dy[i];
        int nx = cur[1] + dx[i];

        if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
        if(vis[ny][nx] || map[ny][nx] == 0) continue;
        vis[ny][nx] = true;
        q.add(new int[]{ny, nx});
      }
    }

    return ret;
  }
}