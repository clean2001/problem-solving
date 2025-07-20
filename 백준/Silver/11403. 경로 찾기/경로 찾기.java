import java.io.*;
import java.security.MessageDigest;
import java.util.*;
import java.util.jar.Attributes;

class Main {
  private static List<List<Integer>> adj;
  static int[] dy = {1, -1, 0, 0, 0, 0};
  static int[] dx = {0, 0, 1, -1, 0, 0};
  static int[] dz = {0, 0, 0, 0, 1, -1};
  static int N, C, T;
  static int[][] rslt;
  static int[][][] vis;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());

    rslt = new int[N][N];

    adj = new ArrayList<>();
    for(int i=0; i<=N; ++i) {
      adj.add(new ArrayList<>());
    }

    for(int i=0; i<N; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; ++j) {
        int a = Integer.parseInt(st.nextToken());

        if(a == 1) {
          adj.get(i).add(j);
        }
      }
    }

    for(int i=0; i<N; ++i) {
      for (int j = 0; j < N; ++j) {
        bfs(i, j);
      }
    }

    for(int i=0; i<N; ++i) {
      for(int j=0; j<N; ++j) {
        bw.write(rslt[i][j]  +" ");

      }
      bw.write("\n");
    }

    bw.flush();
  }

  private static void bfs(int s, int e) {
    Queue<Integer> q = new LinkedList<>();
    q.add(s);
    boolean[] vis = new boolean[N];
    if(s!=e)
      vis[s] = true;

    int cnt = -1;
    while(!q.isEmpty()) {
      cnt++;
      int cur = q.poll();

      if(cur == e && cnt > 0) {
        rslt[s][e] = 1;
        return;
      }
      List<Integer> nexts = adj.get(cur);

      for(int next : nexts) {
        if(vis[next]) continue;

        vis[next] = true;
        q.add(next);
      }

    }
  }

}