import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class Main {
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, M, W;
  static int[][] map;
  static int ans = -1;

  static int[] dy = {1, -1, 0, 0};
  static int[] dx = {0, 0, 1, -1};

  static List<List<int[]>> adj;

  public static void main(String[] args) throws Exception {
    int T = Integer.parseInt(br.readLine());

    while(T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      W = Integer.parseInt(st.nextToken());

      adj = new ArrayList<>();
      for(int i=0; i<=N; ++i) {
        adj.add(new ArrayList<>());
      }

      // 도로
      for(int i=0; i<M; ++i) {
        st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        adj.get(s).add(new int[]{e, w});
        adj.get(e).add(new int[]{s, w});
      }

      // 웜홀
      for(int i=0; i<W; ++i) {
        st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        adj.get(s).add(new int[]{e, -w});
      }

      if(solve(1)) {
        bw.write("YES\n");
      } else {
        bw.write("NO\n");
      }
    }

    bw.flush();

  }

  private static boolean solve(int s) throws Exception {
    long[] dist = new long[N+1]; // 거리 배열
    for(int i=0; i<=N; ++i) {
      dist[i] = Integer.MAX_VALUE;
    }

    dist[s] = 0;
    for(int i=1; i<=N; ++i) {
      for(int j=1; j<=N; ++j) {
//        if(dist[j] == Integer.MAX_VALUE) continue;

        List<int[]> nexts = adj.get(j); // 엣지들
        for(int[] next : nexts) {
          int n = next[0];
          int w = next[1];

          if(dist[n] > dist[j] + w) {
            dist[n] = dist[j] + w;

            if(i == N) {
              return true; // 음의 사이클 존재
            }
          }
        }
      }
    }

    return false;
  }

}