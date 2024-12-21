
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class Main {
  static int n;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 점화식: 맨 왼쪽 -> dp[i-1][0] + dp[i][0]
    // 중간: Math.max(dp[i-1][j-1], dp[i-1][j]) + dp[i][j]
    // 맨 오른쪽 dp[i-1][j-1] + dp[i][j]

    n = Integer.parseInt(br.readLine());
    int[][] dp = new int[n][n];
    for(int i=0; i<n; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j=0; j<=i; ++j) {
        dp[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for(int i=1; i<n; ++i) {
      for(int j=0; j<=i; ++j) {
        if(j == 0) {
          dp[i][j] = dp[i][j] + dp[i-1][j];
        } else if(j == i) {
          dp[i][j] = dp[i-1][j-1] + dp[i][j];
        } else {
          dp[i][j] = dp[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
        }
      }
    }

    int ans = 0;
    for(int i=0; i<n; ++i) {
      ans = Math.max(dp[n-1][i], ans);
    }

    System.out.println(ans);
  }
}
