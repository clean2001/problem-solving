import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class Main {
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int T;
  static long[][] dp;

  public static void main(String[] args) throws Exception {
    T = Integer.parseInt(br.readLine());
    dp = new long[31][31];

    for(int i=0; i<31; ++i) {
      dp[i][1] = i;
      dp[i][0] = 1;
      dp[i][i] = 1;
    }

    while(T -- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      bw.write(comb(M, N) + "\n");
    }

    bw.flush();
  }

  private static long comb(int N, int M) {
    if(dp[N][M] > 0) return dp[N][M];

    return dp[N][M] = (comb(N-1, M-1) + comb(N-1, M));
  }

}