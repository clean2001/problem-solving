
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

    for(int i=0; i<n-1; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      adj.get(a).add(new int[]{b, w});
      adj.get(b).add(new int[]{a, w});
    }

    int[] vis1 = new int[n+1]; // 첫번째 탐색
    int[] vis2 = new int[n+1]; // 두번째 탐색

    // 첫번째 탐색 => 아무 노드나 하나 잡아서 맨 말단을 구한다. 여기선 1에서 시작
    int[] ret1 = bfs(1);
    int[] ret2 = bfs(ret1[0]);

    System.out.println(ret2[1]); // 지름 출력
  }

  private static int[] bfs(int start) {
    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    int[] dist = new int[n+1];
    for(int i=0; i<n+1; ++i) {
      dist[i] = -1;
    }

    dist[start] = 0;

    int[] ret = new int[2];
    while(!q.isEmpty()) {
      int cur = q.poll();

      if(dist[cur] >= ret[1]) {
        ret[0] = cur;
        ret[1] = dist[cur];
      }

      List<int[]> nexts = adj.get(cur);
      for (int[] next : nexts) {
        if(dist[next[0]] != -1) continue;
        dist[next[0]] = dist[cur] + next[1]; // 거리구하기
        q.add(next[0]);
      }
    }

    return ret;
  }
}
