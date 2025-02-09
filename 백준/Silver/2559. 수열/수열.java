import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] sum = new int[N+1];
    for(int i=1; i<=N; ++i) {
      sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
    }

    int ans = (-100) * 100001;
    for(int i=K; i<=N; ++i) {
      ans = Math.max(ans, sum[i] - sum[i-K]);
    }
    bw.write(ans + "\n");
    bw.flush();
  }

}