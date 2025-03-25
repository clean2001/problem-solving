import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
  private static int[][] dp;
  public static int N;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    dp = new int[N+1][3];

    dp[1][0] = dp[1][1] = dp[1][2] = 1;
    for(int i=2; i<=N; ++i) {
      dp[i][0] = (dp[i-1][1] + dp[i-1][2] + dp[i-1][0]) % 9901;
      dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
      dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;
    }

    System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % 9901);
  }
}