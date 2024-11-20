import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main{
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N, K;
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    int[] dist = new int[100001];
    int[] memo = new int[100001];
    for(int i=0; i<100001; ++i) {
      dist[i] = 100001;
    }
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{N, 0});
    int ans = 0;
    dist[N] = 0;
    memo[N] = N;
    while(!q.isEmpty()) {
      int[] cur = q.poll();

      int n1 = cur[0] + 1;
      int n2 = cur[0] - 1;
      int n3 = cur[0] * 2;

      if(cur[0] == K) {
        ans = cur[1]; break;
      }

      if(n1 >= 0 && n1 <= 100000 && dist[n1] == 100001) {
        dist[n1] = cur[1] + 1;
        q.add(new int[]{n1, dist[n1]});
        memo[n1] = cur[0];
      }

      if(n2 >= 0 && n2 <= 100000 && dist[n2] == 100001) {
        dist[n2] = cur[1] + 1;
        q.add(new int[]{n2, dist[n2]});
        memo[n2] = cur[0];
      }

      if(n3 >= 0 && n3 <= 100000 && dist[n3] == 100001) {
        dist[n3] = cur[1] + 1;
        q.add(new int[]{n3, dist[n3]});
        memo[n3] = cur[0];
      }
    }


    Deque<Integer> dq = new LinkedList<>();
    int current = K;
    dq.addLast(K);
      while(current != N) {
        dq.addLast(memo[current]);
        current = memo[current];
      }

      bw.write(ans + "\n");
      while(!dq.isEmpty()) {
        bw.write(dq.pollLast() + " ");
      }
      bw.flush();
  }
}