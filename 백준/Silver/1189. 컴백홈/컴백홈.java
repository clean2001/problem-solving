import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
  static int R, C, ans;
  static boolean[][] vis;
  static int[] dy = {1, -1, 0, 0};
  static int[] dx = {0, 0, 1, -1};
  static char[][] map;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    map = new char[R][C];
    for(int i=0; i<R; ++i) {
      String s = br.readLine();
      for(int j=0; j<C; ++j) {
        map[i][j] = s.charAt(j);
      }
    }

    ans = 0;
    vis = new boolean[R][C];
    vis[R-1][0] = true;
    dfs(R-1, 0, K, 1);

    bw.write(ans + "\n");
    bw.flush();
  }

  private static void dfs(int y, int x, int K, int cnt) {

    if (y == 0 && x == C - 1) {
      if(cnt == K) ans++;

      return;
    }

    for(int i=0; i<4; ++i) {
      int ny = y + dy[i];
      int nx = x + dx[i];

      if(ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
      if(vis[ny][nx]) continue;
      if(map[ny][nx] == 'T') continue;

      vis[ny][nx] = true;
      dfs(ny, nx, K, cnt+1);
      vis[ny][nx] = false;
    }
  }
}