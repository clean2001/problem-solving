import java.io.*;
import java.util.*;

class Main {
  static int N, k;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    Integer[] arr = new Integer[N];

    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr, (a, b) -> b-a);
    System.out.println(arr[k-1]);
  }

}