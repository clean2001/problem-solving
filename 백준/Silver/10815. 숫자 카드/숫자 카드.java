import java.io.*;
import java.util.*;

class Main {
  static int N, M;
  static Set<Integer> set = new HashSet<>();
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
        bw.write("1 ");
      } else {
        bw.write("0 ");
      }
    }

    bw.flush();
  }
}