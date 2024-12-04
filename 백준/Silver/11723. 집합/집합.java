import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


class Main {
  private static String S;
  private static int M;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    M = Integer.parseInt(br.readLine());

    Set<Integer> set = new HashSet<>();
    for(int i=0; i<M;++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String a = st.nextToken();


      if(a.equals("add")) {
        int b = Integer.parseInt(st.nextToken());
        set.add(b);
      } else if(a.equals("remove")) {
        int b = Integer.parseInt(st.nextToken());
        set.remove(b);
      } else if(a.equals("check")) {
        int b = Integer.parseInt(st.nextToken());
        if(set.contains(b)) bw.write("1\n");
        else bw.write("0\n");
      } else if(a.equals("toggle")) {
        int b = Integer.parseInt(st.nextToken());
        if (set.contains(b)) {
          set.remove(b);
        } else {
          set.add(b);
        }
      } else if(a.equals("all")) {
        for(int k=1; k<=20; ++k) set.add(k);
      } else {
        set.clear();
      }
    }
    
    bw.flush();
  }
}