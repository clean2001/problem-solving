import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
  private static int[] arr, dp;
  private static int N, M;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    dp = new int[N+1];
    arr = new int[N+1];

    st = new StringTokenizer(br.readLine());
    for(int i=1; i<=N; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
      dp[i] = dp[i-1] + arr[i];
    }

    for(int i=0; i<M; ++i) {
      st = new StringTokenizer(br.readLine());

      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());

      System.out.println((dp[e] - dp[s-1]));
    }
  }
}