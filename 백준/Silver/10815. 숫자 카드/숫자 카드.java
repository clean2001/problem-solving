import java.io.*;
import java.util.*;

class Main {
  static int N, M;
  static Set<Integer> set = new HashSet<>();
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; ++i) {
      int n = Integer.parseInt(st.nextToken());
      set.add(n);
    }

    M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<M; ++i) {
      int n = Integer.parseInt(st.nextToken());
      if (set.contains(n)) {
        System.out.print("1 ");
      } else {
        System.out.print("0 ");
      }
    }


  }
}