import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


class Main {
  private static String S;
  private static int ans = 0;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = 1;
    while(true) {
      int N = Integer.parseInt(br.readLine());
      if(N == 0) break;

      int[][] arr = new int[N][3];

      for(int i=0; i<N; ++i) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[i][0] = Integer.parseInt(st.nextToken());
        arr[i][1] = Integer.parseInt(st.nextToken());
        arr[i][2] = Integer.parseInt(st.nextToken());
      }

      int dp[][] = new int[N][3];
      dp[0][0] = Integer.MAX_VALUE;
      dp[0][1] = arr[0][1];
      dp[0][2] = arr[0][2] + arr[0][1];


      for(int i=1; i<N; ++i) {
        dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][0];
        dp[i][1] = Math.min(dp[i-1][0], Math.min(dp[i][0], Math.min(dp[i-1][1], dp[i-1][2]))) + arr[i][1]; // 옆에서 오는 경우 추가
        dp[i][2] = Math.min(dp[i][1], Math.min(dp[i-1][1], dp[i-1][2])) + arr[i][2]; // 옆에서 오는 경우 추가
      }


      System.out.println(t + ". " + dp[N-1][1]);
      t++;
    }
  }
}