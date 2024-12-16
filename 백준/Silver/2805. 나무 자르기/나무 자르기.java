import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for(int i=0; i<N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    long s = 0, e = 2000000001;
    long ans = 0;
    while(s <= e) {
      long mid = (s + e) / 2;

//      System.out.println(mid);

      if(can(mid, arr, M)) {
        ans = mid;
        s = mid + 1;
      } else {
        e = mid - 1;
      }
    }

    System.out.println(ans);

  }

  private static boolean can(long mid, int[] arr, int M) {
    long sum = 0;
    for (int n : arr) {
      if(n > mid) sum += (long)n - mid;
    }
    return sum >= M;
  }
}