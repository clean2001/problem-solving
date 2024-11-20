import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N, K;
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    int[] vis = new int[100001];
    for(int i=0; i<100001; ++i) {
      vis[i] = 100001;
    }
    vis[N] = 0;
    pq.add(new int[]{N, 0});
    int ans = 0;
    while(!pq.isEmpty()) {
      int[] cur = pq.poll();
      int n1 = cur[0] * 2;
      int n2 = cur[0] + 1;
      int n3 = cur[0] - 1;

      if(cur[0] == K) {
        ans = cur[1];
        break;
      }

      if(n1 >= 0 && n1 <= 100000 && vis[n1] > cur[1]) {
        vis[n1] = cur[1];
        pq.add(new int[]{n1, vis[n1]});
      }

      if(n2 >= 0 && n2 <= 100000 && vis[n2] > cur[1]+1) {
        vis[n2] = cur[1] + 1;
        pq.add(new int[]{n2, vis[n2]});
      }

      if(n3 >= 0 && n3 <= 100000 && vis[n3] > cur[1]+1) {
        vis[n3] = cur[1] + 1;
        pq.add(new int[]{n3, vis[n3]});
      }
    }

    System.out.println(ans);

  }
}