import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
  private static int N, M;
  private static long MAX_VAL = 100000000;
  private static List<long[]> adj = new ArrayList<>();
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    for (int i = 0; i < M; ++i) {
      st = new StringTokenizer(br.readLine());
      long a = Integer.parseInt(st.nextToken());
      long b = Integer.parseInt(st.nextToken());
      long w = Integer.parseInt(st.nextToken());

      adj.add(new long[]{a, b, w});
    }

    // dist 배열 초기화
    long[] dist = new long[N + 1];
    for (int i = 0; i <= N; ++i) {
      dist[i] = MAX_VAL;
    }

    dist[1] = 0;

    // 벨만 포드
    for (int i = 0; i < N - 1; ++i) {
      for (int j = 0; j < M; ++j) {
        long[] edge = adj.get(j);
        int s = (int)edge[0];
        int e = (int)edge[1];
        long w = edge[2];

        if(dist[s] == MAX_VAL) continue;

        dist[e] = Math.min(dist[e], dist[s] + w);
      }
    }

    int ans = 0;
    // 음수 사이클 체크
    for (int j = 0; j < M; ++j) {
      long[] edge = adj.get(j);
      int s = (int)edge[0];
      int e = (int)edge[1];
      long w = edge[2];
      if(dist[s] == MAX_VAL) continue;
      if (dist[e] > dist[s] + w) {
        ans = -1;
        break;
      }
    }

    if(ans == -1) {
      System.out.println(ans);
    } else {
      for(int i=2; i<=N; ++i) {
        if(dist[i] >= MAX_VAL) {
          System.out.println(-1);
        } else {
          System.out.println(dist[i]);
        }
      }
    }

  }
}
