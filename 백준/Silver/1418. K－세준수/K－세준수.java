import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int K = Integer.parseInt(br.readLine());

    int[] dp = new int[N+1];
    for(int i=2; i<=N; ++i) {
      if(dp[i] > 0) continue;

      for(int j=i; j<=N; j += i) {
        dp[j] = Math.max(dp[j], i);
      }
    }

    int ans = 0;
    for(int i=1; i<=N; ++i) {
      if(dp[i] <= K) ans++;
    }

    bw.write(ans + "\n");
    bw.flush();
  }

}