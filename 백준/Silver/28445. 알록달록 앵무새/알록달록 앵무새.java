import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

  private static boolean[] vis;
  private static int ans = 0;
  private static Map<String, Integer> map;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] s = new String[4];
    StringTokenizer st = new StringTokenizer(br.readLine());
    s[0] = st.nextToken(); s[1] = st.nextToken();
    st = new StringTokenizer(br.readLine());
    s[2] = st.nextToken(); s[3] = st.nextToken();

    Set<String> set = new TreeSet<>();
    for(int i=0; i<4; ++i) {
      for(int j=0; j<4; ++j) {
        String str = s[i] + " " + s[j];
        set.add(str);
      }
    }

    for (String ans : set) {

      System.out.println(ans);

    }
  }



}