import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Main {
  private static int[] dp;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    dp = new int[N+1];
    for(int i=0; i<=N; ++i) {
      dp[i] = Integer.MAX_VALUE;
    }

    dp[1] = 0;

    System.out.println(solve(N));
  }

  private static int solve(int n) {
    if(n <= 1) return 0;
    if(dp[n] != Integer.MAX_VALUE) return dp[n];
    int ret1 = Integer.MAX_VALUE;
    int ret2 = Integer.MAX_VALUE;
    int ret3 = Integer.MAX_VALUE;
    if(n % 3 == 0) {
      ret1 = solve(n / 3);

    }

    if(n % 2 == 0) {
      ret2 = solve(n / 2);
    }

    ret3 = solve(n-1);

    return dp[n] = Math.min(Math.min(ret1, ret2), ret3) + 1;
  }
}
