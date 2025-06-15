import java.io.*;
import java.security.MessageDigest;
import java.util.*;

class Main {
  private static int C; // 채워야하는 수
  private static int N; // 도시 개수
  private static int[][] arr; // 비용, 사람
  private static int[] dp; // 사람, 비용
  private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    C = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    arr = new int[N][2];
    dp = new int[C+102];

    // 1. DP 배열 초기화
    for(int i=1; i<=C+101; ++i) {
      dp[i] = 200002;
    }

    // 2. 입력 받기
    for(int i=0; i<N; ++i) {
      st = new StringTokenizer(br.readLine());

      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Integer.parseInt(st.nextToken());
    }

    // 3. DP 채우기
    for(int i=0; i<N; ++i) { // 입력
      int cost = arr[i][0];
      int p = arr[i][1];

      // 갱신
      for(int j=p; j<=C+101; ++j) {
        dp[j] = Math.min(dp[j], dp[j-p] + cost);
      }
    }
    
    int ans = Integer.MAX_VALUE;
    for(int i=C; i<=C+101; ++i) {
      ans = Math.min(ans, dp[i]);
    }
    System.out.println(ans);

    bw.flush();
  }
}