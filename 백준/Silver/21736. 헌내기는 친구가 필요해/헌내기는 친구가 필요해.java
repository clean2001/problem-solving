import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;

class Main {
  private static int ty, tx;
  private static int n, m;
  private static int[][] dist;
  private static int[] dy = {1, -1, 0, 0};
  private static int[] dx = {0, 0, 1, -1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    char[][] map = new char[n][m];
    int sy = 0, sx = 0;
    for(int i=0; i<n; ++i) {
      String s = br.readLine();
      for(int j=0; j<m; ++j) {
        map[i][j] = s.charAt(j);

        if(map[i][j] == 'I') {
          sy = i;
          sx = j;
        }
      }
    }

    int ret = bfs(sy, sx, map);
    if(ret == 0) {
      System.out.println("TT");
    } else {
      System.out.println(ret);
    }
  }

  private static int bfs(int sy, int sx, char[][] map) {
    int n = map.length, m = map[0].length;
    int ans = 0;
    boolean[][] vis = new boolean[n][m];
    vis[sy][sx] = true;
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{sy, sx});
    while(!q.isEmpty()) {
      int[] cur = q.poll();
      for(int i=0; i<4; ++i) {
        int ny = cur[0] + dy[i];
        int nx = cur[1] + dx[i];

        if(ny < 0 || ny >= n || nx < 0 || nx >= m) {
          continue;
        }
        if(vis[ny][nx] || map[ny][nx] == 'X') continue;
        vis[ny][nx] = true;
        q.add(new int[] {ny, nx});
        if(map[ny][nx] == 'P') ans++;
      }
    }
    return ans;
  }
}