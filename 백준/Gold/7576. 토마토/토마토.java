import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


class Main {
  public static int M, N;
  private static int[] dy = {1, -1, 0, 0};
  private static int[] dx = {0, 0, 1, -1};
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    int[][] map = new int[N][M];

    for(int i=0; i<N; ++i) {
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<M; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    System.out.println(bfs(map));
  }

  private static int bfs(int[][] m) {
    Queue<int[]> q = new LinkedList<>();
    for(int i=0; i<N; ++i) {
      for(int j=0; j<M; ++j) {
        if(m[i][j] == 1) {
          q.add(new int[]{i, j, 0});
        }
      }
    }

    int ans = 0;
    while(!q.isEmpty()) {
      int[] cur = q.poll();
      ans = cur[2];

      for(int i=0; i<4; ++i) {
        int ny = cur[0] + dy[i];
        int nx = cur[1] + dx[i];

        if(ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
        if(m[ny][nx] != 0) continue;

        m[ny][nx] = 1;
        q.add(new int[]{ny, nx, cur[2] + 1});
      }

    }

    // 체크
    for(int i=0; i<N; ++i) {
      for(int j=0; j<M; ++j) {
        if(m[i][j] == 0) {
          return -1;
        }
      }
    }

    return ans;
  }
}