import java.io.*;
import java.util.*;

class Main {
  static int N;
  static int[][] arr;
  static boolean[][] vis;
  static int[] dy = {1, -1, 0, 0};
  static int[] dx = {0, 0, 1, -1};
  static int ans = 0;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    arr = new int[N][N];
    vis = new boolean[N][N];
    int maxHeight = -1;
    for(int i=0; i<N; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; ++j) {
        arr[i][j] = Integer.parseInt(st.nextToken());
        maxHeight = Math.max(maxHeight, arr[i][j]);
      }
    }

    for(int h=0; h<=maxHeight; ++h) { // 비가 어디까지 옴?
      int cnt = 0;
      vis = new boolean[N][N];
      for(int i=0; i<N; ++i) {
        for(int j=0; j<N; ++j) {
          if(!vis[i][j] && arr[i][j] > h) {
            dfs(i, j, h);
            cnt++;
          }
        }
      }
      ans = Math.max(ans, cnt);
    }

    System.out.println(ans);
  }

  private static void dfs(int y, int x, int h) {
    vis[y][x] = true;
    for(int i=0; i<4; ++i) {
      int ny = y + dy[i], nx = x + dx[i];
      if(ny >=N || nx >= N || ny < 0 || nx < 0) continue;
      if(vis[ny][nx]) continue;
      if(arr[ny][nx] <= h) continue;
      dfs(ny, nx, h);
    }
  }
}