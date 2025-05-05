import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    Set<String> set = new HashSet<>();
    int total = 0;

    for(int i=0; i<N; ++i) {
      String cur = br.readLine();

      if(cur.equals("ENTER")) {
        total += set.size();
        set.clear();
      } else {
        set.add(cur);
      }
    }

    total += set.size();
    System.out.println(total);

  }
}