
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class Main {
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());
    List<List<Integer>> adj = new ArrayList<>();
    for(int i=0; i<=N; ++i) {
      adj.add(new ArrayList<>());
    }

    for(int i=0; i<N-1; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      adj.get(a).add(b);
      adj.get(b).add(a);
    }

    int[] parent = bfs(adj, N);

    for(int i=2; i<=N; ++i) {
      System.out.println(parent[i]);
    }
  }

  private static int[] bfs(List<List<Integer>> adj, int N) {
    int[] parent = new int[N+1];
    parent[1] = -1; // 방문
    Queue<Integer> q = new LinkedList<>();
    q.add(1);
    while(!q.isEmpty()) {
      int cur = q.poll();
      List<Integer> nexts = adj.get(cur);

      for(int next : nexts) {
        if(parent[next] != 0) continue;
        parent[next] = cur;
        q.add(next);
      }
    }

    return parent;
  }
}