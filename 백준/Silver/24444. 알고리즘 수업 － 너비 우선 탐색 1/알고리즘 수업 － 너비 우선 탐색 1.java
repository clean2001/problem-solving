import java.io.*;
import java.util.*;

class Main {
  private static List<List<Integer>> adj;
  static int[] dy = {1, -1, 0, 0, 0, 0};
  static int[] dx = {0, 0, 1, -1, 0, 0};
  static int[] dz = {0, 0, 0, 0, 1, -1};
  static int N, M, K;
  static int[] vis;
  static int[] ans;
  static int turn = 1;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    adj = new ArrayList<>();
    ans = new int[N+1];
    vis = new int[N+1];
    for(int i=0; i<=N; ++i) {
      adj.add(new ArrayList<>());
    }

    for(int i=0; i<M; ++i) {
      st = new StringTokenizer(br.readLine());

      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      adj.get(a).add(b);
      adj.get(b).add(a);
    }

    for(int i=1; i<=N; ++i) {
      List<Integer> nexts = adj.get(i);
      Collections.sort(nexts);
    }

    Queue<Integer> q = new LinkedList<>();
    int turn = 1;
    vis[K] = turn++;
    q.add(K);
    while(!q.isEmpty()) {
      int cur = q.poll();



      List<Integer> nexts = adj.get(cur);

      for (Integer next : nexts) {
        if(vis[next] != 0) continue;
        vis[next] = turn++;
        q.add(next);
      }
    }

    for(int i=1; i<=N; ++i) {
      bw.write(vis[i] + "\n");
    }

    bw.flush();
  }


}