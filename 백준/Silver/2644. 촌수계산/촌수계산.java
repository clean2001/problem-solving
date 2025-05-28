import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
  static int[] vis;
  static List<List<Integer>> adj;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    int M = Integer.parseInt(br.readLine());

    vis =  new int[N + 1];
    adj = new ArrayList<>();
    for(int i=0; i<=N; ++i) {
      adj.add(new ArrayList<>());
    }

    for(int i=0; i<M; ++i) {
      st = new StringTokenizer(br.readLine());
      int n1 = Integer.parseInt(st.nextToken());
      int n2 = Integer.parseInt(st.nextToken());

      adj.get(n1).add(n2);
      adj.get(n2).add(n1);
    }

    for(int i=0; i<=N; ++i) {
      vis[i] = -1;
    }

    bfs(a, b);

    System.out.println(vis[b]);
  }

  private static void bfs(int a, int b) {
    Queue<Integer> q = new LinkedList<>();
    q.add(a);
    vis[a] = 0;

    while(!q.isEmpty()) {
      int cur = q.poll();
      List<Integer> nexts = adj.get(cur);
      for(Integer next : nexts) {
        if(vis[next] != -1) continue;
        vis[next] = vis[cur] + 1;
        q.add(next);
      }
    }
  }
}