
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class Main {
  static int N, M;
  static List<Integer> list;
  static Set<String> set;
  static boolean[] vis;

  static int[][] matrix;
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    vis = new boolean[N];
    list = new ArrayList<>();
    for(int i=0; i<N; ++i) {
      list.add(Integer.parseInt(st.nextToken()));
    }

    Collections.sort(list);

    dfs(new LinkedList<>());


    bw.flush();

  }

  private static void dfs(LinkedList<Integer> dq) throws Exception {
    if(dq.size() == M) {
      StringBuilder sb = new StringBuilder();
      for (Integer val : dq) {
        sb.append(val + " ");
      }

      bw.write(sb.toString() + "\n");
      return;
    }

    int before = -1;
    for(int i=0; i<N; ++i) {
      if(vis[i]) continue;
      if(before == list.get(i)) continue;

      before = list.get(i);
      vis[i] = true;
      dq.addLast(list.get(i));
      dfs(dq);
      dq.pollLast();
      vis[i] = false;
    }


  }


}