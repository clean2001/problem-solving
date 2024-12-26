
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class Main {
  static int N;
  static boolean[][] vis;
  static int ans = 0;
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


  public static void main(String[] args) throws Exception {
    N = Integer.parseInt(br.readLine());
    vis = new boolean[N][N];

    dfs(0);

    bw.write(ans + "\n");

    bw.flush();
  }

  private static void dfs(int cur) {
    if(cur == N) {
      ans++;
      return;
    }

    for(int i=0; i<N; ++i) {
      // cur, i 에 놓을 수 있는지를 체크
      boolean can = true;
      // 1. 세로 체크
      for(int j=0; j<N; ++j) {
        if(vis[j][i]) {
          can = false; break;
        }
      }

      if(!can) continue;

      // 2. 좌측 상단 -> 우측 하단 대각선 체크
      for(int j=0; j<N; ++j) {
        int k = i - cur + j;
        if(k < 0 || k >= N) continue;
        if(vis[j][k]) {
          can = false; break;
        }
      }

      if(!can) continue;

      // 3. 우측 상단 -> 좌측 하단 대각선 체크
      for(int j=0; j<N; ++j) {
        int k = i + cur - j;
        if(k < 0 || k >= N) continue;
        if(vis[j][k]) {
          can = false; break;
        }
      }

      if(can) {
        vis[cur][i] = true;
        dfs(cur+1);
        vis[cur][i] = false;
      }

    }
  }

}