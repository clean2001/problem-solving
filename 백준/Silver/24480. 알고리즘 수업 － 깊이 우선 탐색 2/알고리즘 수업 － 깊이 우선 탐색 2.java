import java.io.*;
import java.util.*;

class Main {
  private static List<List<Integer>> adj;
  static int[] dy = {1, -1, 0, 0, 0, 0};
  static int[] dx = {0, 0, 1, -1, 0, 0};
  static int[] dz = {0, 0, 0, 0, 1, -1};
  static int N, M, K;
  static boolean[] vis;
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
    vis = new boolean[N+1];
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
      Collections.sort(nexts, Collections.reverseOrder());
    }

    dfs(K);

    for(int i=1; i<=N; ++i) {
      bw.write(ans[i] + "\n");
    }

    bw.flush();
  }

  private static void dfs(int cur) {
    vis[cur] = true;
    ans[cur] = turn++;

    List<Integer> nexts = adj.get(cur);
    for (Integer next : nexts) {
      if(vis[next]) continue;
      dfs(next);
    }

  }

}