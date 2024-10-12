import javax.print.attribute.IntegerSyntax;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
  public static int N, M;
  public static List<List<int[]>> adj;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
      int w = Integer.parseInt(st.nextToken());
      adj.get(a).add(new int[]{b, w});
      adj.get(b).add(new int[]{a, w});
    }

    st = new StringTokenizer(br.readLine());
    int n1 = Integer.parseInt(st.nextToken());
    int n2 = Integer.parseInt(st.nextToken());

    long total1 = 0, total2 = 0;

    long[] lengthArr = new long[3];
    lengthArr[0] = solve(1, n1);
    lengthArr[1] = solve(n1, n2);
    lengthArr[2] = solve(n2, N);

    for(int i=0; i<3; ++i) {
      if(lengthArr[i] < 0) {
        total1 = Long.MAX_VALUE; break;
      } else {
        total1 += lengthArr[i];
      }
    }



    lengthArr[0] = solve(1, n2);
    lengthArr[1] = solve(n2, n1);
    lengthArr[2] = solve(n1, N);

    for(int i=0; i<3; ++i) {
      if(lengthArr[i] < 0) {
        total2 = Long.MAX_VALUE; break;
      } else {
        total2 += lengthArr[i];
      }
    }

    if(total1 == Long.MAX_VALUE && total2 == Long.MAX_VALUE) {
      System.out.println(-1);
    } else {
      System.out.println(Math.min(total1, total2));
    }

  }

  private static long solve(int s, int e) {
    long[] dist = new long[N+1];
    for(int i=1; i<=N; ++i) {
      dist[i] = Long.MAX_VALUE;
    }
    dist[s] = 0;
    PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
    pq.add(new long[]{s, 0});
    while(!pq.isEmpty()) {
      long[] cur = pq.poll();

      if(cur[0] == e) return cur[1];

      int idx = (int)cur[0];
      List<int[]> nexts = adj.get(idx);
      for(int[] next : nexts) {
         int n = next[0], w = next[1];
        if(dist[n] < (long)w+cur[1]) continue;
        dist[n] = (long)w+cur[1];
        pq.add(new long[]{n, cur[1]+(long)w});
      }
    }

    return -1;
  }

}
