import java.io.*;
import java.security.MessageDigest;
import java.util.*;
import java.util.jar.Attributes;

class Main {
  private static List<List<Integer>> adj;
  static int[] dy = {1, -1, 0, 0};
  static int[] dx = {0, 0, 1, -1};
  static int N, C, T;
  static char[][] map;
  static boolean[][] vis;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    N = Integer.parseInt(br.readLine());
    map = new char[N][N];
    vis = new boolean[N][N];
    for(int i=0; i<N; ++i) {
      String s = br.readLine();
      for(int j=0; j<N; ++j) {
        map[i][j] = s.charAt(j);
      }
    }

    int ans1 = 0;
    for(int i=0; i<N; ++i) {
      for(int j=0; j<N; ++j) {
        if(!vis[i][j]) {
          bfs(map, i, j);
          ans1++;
        }
      }
    }

    for(int i=0; i<N; ++i) {
      for(int j=0; j<N; ++j) {
        if(map[i][j] == 'G') map[i][j] = 'R';
      }
    }

    vis = new boolean[N][N];
    int ans2 = 0;

    for(int i=0; i<N; ++i) {
      for(int j=0; j<N; ++j) {
        if(!vis[i][j]) {
          bfs(map, i, j);
          ans2++;
        }
      }
    }

    bw.write(ans1 + " " + ans2 + "\n");
    bw.flush();
  }

  private static void bfs(char[][] map, int y, int x) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{y, x});
    int cnt = 0;
    vis[y][x] = true;

    while(!q.isEmpty()) {
      int[] cur = q.poll();
      char color = map[cur[0]][cur[1]];

      for(int i=0; i<4; ++i) {
        int ny = cur[0] + dy[i];
        int nx = cur[1] + dx[i];

        if(ny >= N || ny < 0 || nx >=N || nx <0) continue;
        if(vis[ny][nx]) continue;
        if(map[ny][nx] != color) continue;
        cnt++;
        q.add(new int[]{ny, nx});
        vis[ny][nx] = true;
      }
    }

  }
}