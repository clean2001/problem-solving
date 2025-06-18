import java.io.*;
import java.security.MessageDigest;
import java.util.*;

class Main {
  private static List<List<Integer>> adj;
  static int ansCnt = 5001;
  static int ans = 101;
  private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N, M;
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    adj = new ArrayList<>();
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
      bfs(i, N);
    }

    System.out.println(ans);
  }

  private static void bfs(int s, int N) {
    Queue<Integer> q = new LinkedList<>();
    q.add(s);
    int[] vis = new int[N+1];
    for(int i=0; i<=N; ++i) {
      vis[i] = -1;
    }
    vis[s] = 0;
    while(!q.isEmpty()) {
      int cur = q.poll();

      List<Integer> nexts = adj.get(cur);
      for (Integer next : nexts) {
        if(vis[next] != -1) continue;
        vis[next] = vis[cur] + 1;
        q.add(next);
      }
    }

    // 수 계산
    int sum = 0;
    for(int i=0; i<=N; ++i) {
      sum += vis[i];
    }

    if(ansCnt > sum) {
      ansCnt = sum;
      ans = s;
    }
  }
}