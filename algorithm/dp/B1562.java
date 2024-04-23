import java.io.*;
import java.util.*;
// 계단수
class Main {
  static int[][][] dp;
  static final int MOD = 1_000_000_000;
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    dp = new int[N+2][10][1024]; // 자리수, 어떤 수?, visited
    for(int i=0; i<=9; ++i) {
      int vis = 1 << i;
      dp[1][i][vis] = 1;
    }
    for(int i=2; i<=N; ++i) {
      for(int j=0; j<=9; ++j) {
        for(int k=0; k<1024; ++k) {
          if(j==0) {
            int vis = k | (1 << j);
            dp[i][j][vis] = (dp[i][j][vis] + dp[i-1][1][k]) % MOD;
          } else if(j==9) {
            int vis = k | (1 << j);
            dp[i][j][vis] = (dp[i][j][vis] + dp[i-1][8][k]) % MOD;
          } else {
            int vis = k | (1 << j);
            dp[i][j][vis] = (dp[i][j][vis] + dp[i-1][j-1][k] + dp[i-1][j+1][k]) % MOD;
          }
        }
      }
    }

    int ans = 0;
    for(int i=1; i<=9; ++i) {
      ans = (ans + dp[N][i][1023]) % MOD;
    }

    System.out.println(ans);


  }
}