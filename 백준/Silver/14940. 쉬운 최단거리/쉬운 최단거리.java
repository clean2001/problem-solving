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
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    int[][] map = new int[n][m];
    dist = new int[n][m];

    for(int i=0; i<n; ++i) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<m; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());

        if(map[i][j] == 2) {
          ty = i; tx = j;
        }
      }
    }

    for(int i=0; i<n; ++i) {
      for(int j=0; j<m; ++j) {
        dist[i][j] = -1;
      }
    }

    bfs(ty, tx, map);

    for(int i=0; i<n; ++i) {
      for(int j=0; j<m; ++j) {
        if(map[i][j] == 0) dist[i][j] = 0;
        bw.write(dist[i][j] + " ");
      }
      bw.write("\n");
    }

    bw.flush();
  }

  private static void bfs(int ty, int tx, int[][] map) {
    Queue<int[]> q = new LinkedList<>();
    dist[ty][tx] = 0;
    q.add(new int[]{ty, tx});
    while(!q.isEmpty()) {
      int[] cur = q.poll();

      for(int i=0; i<4; ++i) {
        int ny = cur[0] + dy[i];
        int nx = cur[1] + dx[i];

        if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
        if(map[ny][nx] == 0) continue;
        if(dist[ny][nx] != -1) continue;

        dist[ny][nx] = dist[cur[0]][cur[1]] + 1;
        q.add(new int[]{ny, nx});
      }
    }
  }
}