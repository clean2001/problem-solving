import java.io.*;
import java.util.*;

class Main {
  static int INF = 4_000_001;
  static int[][] dp;
  static int V, E;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    dp = new int[V+1][V+1];
    for(int i=0; i<=V; ++i) {
      for(int j=0; j<=V; ++j) {
        dp[i][j] = INF;
      }
    }

    for(int i=0; i<E; ++i) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());

      dp[a][b] = d;
    }
    

    for(int k=1; k<=V; ++k) {
      for(int i=1; i<=V; ++i) {
        for(int j=1; j<=V; ++j) {
          dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
        }
      }
    }
    

    int ans = INF;
    for(int i=1; i<=V; ++i) {
      ans = Math.min(ans, dp[i][i]);
    }

    if (ans == INF) {
      System.out.println(-1);
    } else {
      System.out.println(ans);
    }
  }
}