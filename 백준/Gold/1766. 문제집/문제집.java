import java.io.*;
import java.security.MessageDigest;
import java.util.*;
import java.util.jar.Attributes;

class Main {
  private static List<List<Integer>> adj;
  static int[] dy = {1, -1, 0, 0};
  static int[] dx = {0, 0, 1, -1};
  static int R, C, T;
  static int[][] map;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] ind = new int[N+1];
    List<List<Integer>> adj = new ArrayList<>();
    for(int i=0; i<=N; ++i) {
      adj.add(new ArrayList<>());
    }

    for(int i=0; i<M; ++i) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      ind[b]++;

      adj.get(a).add(b);
    }

    // 0개인거 세기
    Queue<Integer> pq = new PriorityQueue<>();
    for(int i=1; i<=N; ++i) {
      if(ind[i] == 0) pq.add(i);
    }

    while(!pq.isEmpty()) {
      int cur = pq.poll();
      bw.write(cur + " ");

      List<Integer> nexts = adj.get(cur);
      for (Integer next : nexts) {
        ind[next]--;
        if(ind[next] == 0) {
          pq.add(next);
        }
      }
    }

    bw.flush();
  }
}