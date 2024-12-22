
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class Main {
  static int n;
  static List<List<int[]>> adj;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    adj = new ArrayList<>();
    for(int i=0; i<=n; ++i) {
      adj.add(new ArrayList<>());
    }

    for(int i=0; i<n; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int cur = Integer.parseInt(st.nextToken());
      while(true) {
        int next = Integer.parseInt(st.nextToken());
        if(next == -1) break;

        int weight = Integer.parseInt(st.nextToken());
        adj.get(cur).add(new int[]{next, weight});
      }
    }

    // 1번 기준 가장 먼점 찾기
    int[] ret1 = bfs(1);
    int[] ret2 = bfs(ret1[0]);

    System.out.println(ret2[1]);

  }

  private static int[] bfs(int start) {
    Queue<Integer> q = new LinkedList<>();
    int[] dist =  new int[n+1];
    for(int i=0; i<=n; ++i) {
      dist[i] = -1;
    }
    int ret = start;
    dist[start] = 0;
    q.add(start);
    while(!q.isEmpty()) {
      int cur = q.poll();

      if(dist[cur] > dist[ret]) {
        ret = cur;
      }
      List<int[]> nexts = adj.get(cur);
      for (int[] next : nexts) {
        if(dist[next[0]] != -1) continue;
        q.add(next[0]);
        dist[next[0]] = next[1] + dist[cur];
      }
    }

    return new int[] {ret, dist[ret]};

  }
}
