import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
  private static int[] dp;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n, k;
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    dp = new int[100001];

    for(int i=0; i<=k; ++i) {
      dp[i] = 100001;
    }

    dp[0] = 1;

    int[] coins = new int[n];
    for(int i=0; i<n; ++i) {
      coins[i] = Integer.parseInt(br.readLine());
      dp[coins[i]] = 1;
    }

    for(int i=0; i<n; ++i) {
      for(int j=1; j<=k; ++j) {
        if(j - coins[i] > 0) {
          dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
        }
      }
    }

    if(dp[k] == 100001) System.out.println(-1);
    else System.out.println(dp[k]);
  }
}