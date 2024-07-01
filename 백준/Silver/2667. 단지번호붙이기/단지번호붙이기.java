import java.io.*;
import java.util.*;

class Main {
  static int N;
  static int[][] map;
  static int[] dy = {1, 0, -1, 0};
  static int[] dx = {0, 1, 0, -1};
  static int cnt = 0;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    for(int i=0; i<N; ++i) {
      String line = br.readLine();
      for(int j=0; j<N; ++j) {
        map[i][j] = line.charAt(j) - '0';
      }
    }

    int ans =0;
    List<Integer> result = new ArrayList<>();
    for(int i=0; i<N; ++i) {
      for(int j=0; j<N; ++j) {
        if(map[i][j] == 0) continue;
        cnt=0;
        dfs(i, j);
        ans++;
        result.add(cnt);
      }
    }

    System.out.println(result.size());
    Collections.sort(result);
    for (Integer i : result) {
      System.out.println(i);
    }
  }

  static void dfs(int y, int x) {
    cnt++;
    map[y][x] = 0;
    for(int i=0; i<4; ++i) {
      int ny = y + dy[i];
      int nx = x + dx[i];

      if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
      if(map[ny][nx] == 0) continue;

      dfs(ny, nx);
    }
  }
}