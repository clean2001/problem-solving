import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class Main {
  static Set<Integer> set1 = new HashSet<>();
  static Set<Integer> set2 = new HashSet<>();
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N, M;
    int cnt = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; ++i) {
      int a = Integer.parseInt(st.nextToken());
      set1.add(a);
      cnt++;
    }

    st = new StringTokenizer(br.readLine());
    for(int i=0; i<M; ++i) {
      int a = Integer.parseInt(st.nextToken());
      set2.add(a);
      if(!set1.contains(a)) cnt++;
    }

    set1.retainAll(set2);

    System.out.println(cnt - set1.size());
  }
}