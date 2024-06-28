import java.io.*;
import java.util.*;

class Main {
  static int N, M;
  static int[][] map;
  static int ans = 0;

  static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
  static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
  static Queue<int[]> q = new LinkedList<>();
  static boolean[][] vis;
  static int oneCnt = 0;

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
        if(map[i][j] == 1) {
          q.add(new int[]{i, j, 0});
          vis[i][j] = true;
          oneCnt++;
        }

      }
    }

    System.out.println(bfs());
  }

  static int bfs() {
    int ans = Integer.MIN_VALUE;
    while(!q.isEmpty()) {
      int[] cur = q.poll();
      int cy = cur[0], cx = cur[1], d = cur[2];

      for (int i = 0; i < 8; ++i) {
        int ny = cy + dy[i];
        int nx = cx + dx[i];

        if (ny >= N || ny < 0 || nx >= M || nx < 0) continue;
        if (vis[ny][nx]) continue;

        q.add(new int[]{ny, nx, d+1});
        ans = Math.max(ans, d+1);
        vis[ny][nx] = true;
      }
    }
    return ans;
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