import java.io.*;
import java.util.*;

class Main {
  static int N, M;
  static Set<String> set = new HashSet<>();
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    Set<String> set = new HashSet<>();
    for(int i=0; i<N; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String name = st.nextToken();
      String status = st.nextToken();

      if(status.equals("enter")) {
        set.add(name);
      } else {
        set.remove(name);
      }
    }

    List<String> names = new ArrayList<>();
    for(String s : set) {
      names.add(s);
    }

    Collections.sort(names, (a, b)->b.compareTo(a));
    for (String name : names) {
      System.out.println(name);
    }
  }
}