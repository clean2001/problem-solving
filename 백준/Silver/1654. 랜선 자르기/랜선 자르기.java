import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];

    for(int i=0; i<N; ++i) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    long s = 0, e = Long.MAX_VALUE;
    long ans = -1;
    while(s <= e) {
      long mid = (s + e) / 2;

      if(can(mid, arr, K)) { // 더 길게 만들기
        ans = Math.max(ans, mid);
        s = mid + 1;
      } else {
        e = mid - 1;
      }
    }

    bw.write(ans + "\n");
    bw.flush();
  }

  private static boolean can(long mid, int[] arr, int K) {
    int sum = 0;
    for(int i=0; i< arr.length; ++i) {
      sum += (arr[i] / mid);
    }

    return sum >= K;
  }
}