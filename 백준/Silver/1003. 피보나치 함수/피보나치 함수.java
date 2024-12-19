import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {
  private static int M, N;
  private static int[] dx = {1, -1, 0, 0};
  private static int[] dy = {0, 0, 1, -1};
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[][] dp = new int[41][2];
    for(int i=0; i<41; ++i) {
      dp[i][0] = -1;
      dp[i][1] = -1;
    }
    dp[0][0] = 1;
    dp[0][1] = 0;
    dp[1][0] = 0;
    dp[1][1] = 1;

    int T = Integer.parseInt(br.readLine());
    while(T-- > 0) {
      int N = Integer.parseInt(br.readLine());
      for(int i=2; i<=N; ++i) {
        if(dp[i][0] != -1) continue;
        dp[i][0] = dp[i-2][0] + dp[i-1][0];
        dp[i][1] = dp[i-2][1] + dp[i-1][1];
      }

      bw.write(dp[N][0] + " " + dp[N][1] + "\n");
    }

    bw.flush();
  }

}