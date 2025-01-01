import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class Main {
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, M;
  static int[][] map;
  static int ans = -1;

  static int[] dy = {1, -1, 0, 0};
  static int[] dx = {0, 0, 1, -1};

  public static void main(String[] args) throws Exception {
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

    dfs(0, 0, 0);

    bw.write(ans + "\n");
    bw.flush();
  }

  private static void dfs(int y, int x, int depth) throws Exception {
    if(depth == 3) { // bfs 돌리기
      // map을 복사
      int[][] m = new int[N][M];
      for(int i=0; i<N; ++i) {
        for(int j=0; j<M; ++j) {
          m[i][j] = map[i][j];
        }
      }


      for(int i=0; i<N; ++i) {
        for(int j=0; j<M; ++j) {
          if(m[i][j] == 2) { // 시작
            bfs(m, i, j);
          }
        }
      }

      // 안전 영역 세기
      int cnt = 0;
      for(int i=0; i<N; ++i) {
        for(int j=0; j<M; ++j) {
          if(m[i][j] == 0) cnt++;
        }
      }

      ans = Math.max(ans, cnt);
      return;
    }

    for(int i=0; i<N; ++i) {
      for(int j=0; j<M; ++j) {
        if(i < y || (i == y && j < x)) continue;
        
        if(map[i][j] == 0) {
          map[i][j] = 1;
          dfs(i, j+1, depth+1);
          map[i][j] = 0;
        }
      }
    }
  }

  private static void bfs(int[][] m, int y, int x) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] {y, x});
    while(!q.isEmpty()) {
      int[] cur = q.poll();

      for(int i=0; i<4; ++i) {
        int ny = cur[0] + dy[i];
        int nx = cur[1] + dx[i];

        if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
        if(m[ny][nx] != 0) continue;
        m[ny][nx] = 3;
        q.add(new int[]{ny, nx});
      }
    }
  }


}