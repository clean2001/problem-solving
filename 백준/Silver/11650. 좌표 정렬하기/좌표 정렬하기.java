import java.io.*;
import java.util.*;

class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    List<int[]> l = new ArrayList<>();
    for(int i=0; i<N; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] p = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
      l.add(p);
    }
    Collections.sort(l, (a, b) -> {
      if(a[0] == b[0]) return a[1] - b[1];

      return a[0] - b[0];
    });

    l.stream().forEach(a -> System.out.println(a[0] + " " + a[1]));
  }
}