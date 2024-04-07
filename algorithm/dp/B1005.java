import java.io.*;
import java.util.*;
// 1005. ACM craft
class Main {
  static int T, N, K, W;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    T = Integer.parseInt(br.readLine());

    for(int t=0; t<T; ++t) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());

      int[] indegree = new int[N+1];
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      int[] visited = new int[N+1];
      int[] time = new int[N+1];
      boolean[] done = new boolean[N+1];

      for(int i=0; i<=N; ++i) adj.add(new ArrayList<>());

      // 시간 입력받기
      st = new StringTokenizer(br.readLine());
      for(int i=1; i<=N; ++i) time[i] = Integer.parseInt(st.nextToken());

      for(int i=0; i<K; ++i) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        indegree[b]++;
        adj.get(a).add(b);
      }

      W = Integer.parseInt(br.readLine());

      Queue<Integer> q = new LinkedList<>();
      // 처음부터 지을 수 있는 건물
      for(int i=1; i<=N; ++i) {
        if(indegree[i] == 0) {
          visited[i] = time[i];
          q.add(i);
          done[i] = true;
        }
      }

      // q를 돌자
      while(!q.isEmpty()) {
        int cur = q.poll();

        ArrayList<Integer> next = adj.get(cur); //
        for(int n : next) {
          indegree[n]--;
          visited[n] = Math.max(visited[n], visited[cur] + time[n]);
          if(indegree[n] == 0) { // 지을 수 있음
            done[n] = true;
            q.add(n);
          }
        }
      }

      System.out.println(visited[W]);

    }

  }
}