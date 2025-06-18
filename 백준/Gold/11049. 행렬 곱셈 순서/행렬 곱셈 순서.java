import java.io.*;
import java.security.MessageDigest;
import java.util.*;

class Main {
  private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());

    int[] arr = new int[N+1];
    for(int i=0; i<N; ++i) {
      st = new StringTokenizer(br.readLine());

      arr[i] = Integer.parseInt(st.nextToken());
      arr[i+1] = Integer.parseInt(st.nextToken());
    }

    int[][] dp = new int[N][N];
    for(int i=2; i<N+1; ++i) { // 구간의 간격
      for(int j=0; j<N-i+1; ++j) {// 시작점
        dp[j][j+i-1] = Integer.MAX_VALUE;
        for(int k=j; k<j+i-1; ++k) {
          int v = dp[j][k] + dp[k+1][j+i-1] + (arr[j] * arr[j+i] * arr[k+1]);

          dp[j][j+i-1] = Math.min(dp[j][j+i-1], v);
        }
      }
    }

//    for(int i=0; i<N; ++i) {
//      for(int j=0; j<N; ++j) {
//        System.out.print(dp[i][j]  + " ");
//      }
//      System.out.println();
//    }

    System.out.println(dp[0][N-1]);
  }
}