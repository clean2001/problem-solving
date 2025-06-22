import java.io.*;
import java.security.MessageDigest;
import java.util.*;
import java.util.jar.Attributes;

class Main {
  private static List<List<Integer>> adj;
  static int[] dy = {1, -1, 0, 0};
  static int[] dx = {0, 0, 1, -1};
  static int R, C, T;
  static int[][] map;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    int T = Integer.parseInt(br.readLine());

    // dp구하기
    long[] dp = new long[101];
    dp[1] = dp[2] = dp[3] = 1L;
    dp[4] = dp[5] = 2L;
    for(int i=6; i<=100; ++i) {
      dp[i] = dp[i-5] + dp[i-1];
    }
    while(T-- > 0) {
      int N = Integer.parseInt(br.readLine());

      bw.write(dp[N] + "\n");
    }

    bw.flush();
  }
}