import java.io.*;
import java.util.*;

class Main {
  static int N;
  static int[][] map;
  static int[] dy = {1, 0};
  static int[] dx = {0, 1};
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    boolean[][] vis = new boolean[N][N];
    map = new int[N][N];

    for(int i=0; i<N; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; ++j) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {0, 0});
    while(!q.isEmpty()) {
      int[] cur = q.poll();
      for(int i=0; i<2; ++i) {
        int ny = cur[0] + dy[i] * map[cur[0]][cur[1]];
        int nx = cur[1] + dx[i] * map[cur[0]][cur[1]];

        if(ny < 0 || nx <0 || nx >= N || ny >= N) continue;
        if(vis[ny][nx]) continue;

        vis[ny][nx] = true;
        q.add(new int[] {ny, nx});
      }
    }

    if (vis[N - 1][N - 1]) {
      System.out.println("HaruHaru");
    } else {
      System.out.println("Hing");
    }

  }
}