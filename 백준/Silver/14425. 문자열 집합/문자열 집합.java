import java.io.*;
import java.util.*;

class Main {
  static int N, M;
  static Set<String> set = new HashSet<>();
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    for(int i=0; i<N; ++i) {
      String s = br.readLine();
      set.add(s);
    }

    int ans = 0;
    for(int i=0; i<M; ++i) {
      String s = br.readLine();
      if(set.contains(s)) ans++;
    }
    System.out.println(ans);
  }
}