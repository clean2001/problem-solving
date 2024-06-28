import java.io.*;
import java.util.*;

class Main {
  static int N, M;
  static int[][] map;
  static int ans = 0;

  static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
  static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};

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

    ans = Integer.MIN_VALUE;
    for(int i=0; i<N; ++i) {
      for(int j=0; j<M; ++j) {
        if(map[i][j] == 1) continue;
        ans = Math.max(ans, bfs(i, j));
      }
    }

    System.out.println(ans);
  }

  static int bfs(int y, int x) {
    int[][] dist = new int[N][M];

    for(int i=0; i<N; ++i) {
      for(int j=0; j<M; ++j) {
        dist[i][j] = -1;
      }
    }
    dist[y][x] = 0;
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {y, x});
    while(!q.isEmpty()) {
      int[] cur = q.poll();
      int cy = cur[0], cx = cur[1];

      for (int i = 0; i < 8; ++i) {
        int ny = cy + dy[i];
        int nx = cx + dx[i];

        if (ny >= N || ny < 0 || nx >= M || nx < 0)
          continue;
        if (dist[ny][nx] != -1)
          continue;

        if (map[ny][nx] == 1) { // 상어 만남
          return dist[cy][cx] + 1;
        }

        q.add(new int[]{ny, nx});
        dist[ny][nx] = dist[cy][cx] + 1;
      }
    }



    return -1;
  }

  static void print(int[][] dist) {
    for(int i=0; i<N; ++i) {
      for(int j=0; j<M; ++j) {
        System.out.print(dist[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

}