import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static int[] dx = {1, -1, 0, 0};
  public static int[] dy = {0, 0, -1, 1};
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[][] map = new int[n][m];
    for(int i=0; i<n; ++i) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<m; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int ans = 0;
    int cnt = 0;
    for(int i=0; i<n; ++i) {
      for(int j=0; j<m; ++j) {
        if(map[i][j] != 1) continue;

        int ret = bfs(i, j, map, n, m);
        ans = Math.max(ans, ret);
        cnt++;
      }
    }

    bw.write(cnt + "\n" + ans + "\n");
    bw.flush();
  }

  public static int bfs(int sy, int sx, int[][] map, int n, int m) {
    map[sy][sx] = 2;
    int ret = 1;
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{sy, sx});
    while(!q.isEmpty()) {
      int[] cur = q.poll();

      int cy = cur[0];
      int cx = cur[1];
      for(int i=0; i<4; ++i) {
        int ny = cy + dy[i];
        int nx = cx + dx[i];
        if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
        if(map[ny][nx] != 1) continue;

        q.add(new int[]{ny, nx});
        map[ny][nx] = 2;
        ret++;
      }
    }

    return ret;
  }
}