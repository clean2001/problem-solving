import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

  private static boolean[] vis;
  private static int ans = 0;
  private static Map<String, Integer> map;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    long[] arr = new long[N];
    for(int i=0; i<N; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int M = Integer.parseInt(st.nextToken());
      long sum = 0;
      for(int j=0; j<M; ++j) {
        sum += (long)Integer.parseInt(st.nextToken());
      }

      arr[i] = sum;

    }

    Arrays.sort(arr);

    long ans = 0;
    long sub = 0;
    for(int i=0; i<N; ++i) {
      sub += arr[i];
      ans += sub;
    }

    System.out.println(ans);
  }



}