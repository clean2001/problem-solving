import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class Main {
  static int N, K;
  static List<Integer> list;
  static Set<String> set;
  static boolean[] vis;


  static int[][] matrix;
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    bw.write("<");
    Queue<Integer> q = new LinkedList<>();
    for(int i=1; i<=N; ++i) {
      q.add(i);
    }

    int cnt = 1;
    while (!q.isEmpty()) {
      if(cnt % K == 0) {
        bw.write(Integer.toString(q.poll()));
        if(!q.isEmpty()) {
          bw.write(", ");
        } else {
          bw.write(">\n");
        }
      } else {
        q.add(q.poll());
      }
      cnt++;
    }

    bw.flush();

  }



}