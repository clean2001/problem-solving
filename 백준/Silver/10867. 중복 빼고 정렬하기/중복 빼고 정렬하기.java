import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {


  private static Map<String, Integer> map;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    Set<Integer> set = new TreeSet<>();
    for(int i=0; i<N; ++i) {
      int a = Integer.parseInt(st.nextToken());
      set.add(a);
    }

    for(Object a : set.toArray()) {
      bw.write((int)a + " ");
    }
    bw.flush();
  }
  
}