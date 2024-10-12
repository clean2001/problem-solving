import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
  private static int[] parent;
  private static int unite(int a, int b) {
    int p1 = findParent(a);
    int p2 = findParent(b);

    if(p1 == p2) return 0;

    parent[p1] = p2;
    return -1;
  }

  private static int findParent(int a) {
    if(parent[a] == a) return a;

    return parent[a] = findParent(parent[a]);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());

    parent = new int[V+1];
    for(int i=1; i<=V; ++i) {
      parent[i] = i;
    }

    Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
    for(int i=0; i<E; ++i) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      pq.add(new int[]{a, b, w});
    }

    long ans = 0;
    while(!pq.isEmpty()) {
      int[] cur = pq.poll();

      int p1 = findParent(cur[0]);
      int p2 = findParent(cur[1]);
      if(p1 == p2) continue;

      ans += cur[2];
      unite(cur[0], cur[1]);
    }

    System.out.println(ans);
  }
}