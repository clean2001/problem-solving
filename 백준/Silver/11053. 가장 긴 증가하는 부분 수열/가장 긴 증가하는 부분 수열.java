
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


  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());

    int[] arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for(int i=0; i<N; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[N];
    dp[0] = 1;
    int ans = 1;
    for(int i=1; i<N; ++i) {
      int temp = 0;
      for(int j=0; j<i; ++j) {
        if(arr[j] >= arr[i]) continue;

        temp = Math.max(temp, dp[j]);
      }

      dp[i] = temp + 1;
      ans = Math.max(dp[i], ans);
    }
    
    System.out.println(ans);
  }
}