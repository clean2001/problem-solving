import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] indegree = new int[N+1];
    Queue<Integer> q = new LinkedList<>();
    boolean[][] adj = new boolean[N+1][N+1];
    for(int i=0; i<M; ++i) {
      st = new StringTokenizer(br.readLine());
      int K = Integer.parseInt(st.nextToken());
      List<Integer> temp = new ArrayList<>();
      for(int j=0; j<K; ++j) {
        int a = Integer.parseInt(st.nextToken());

        temp.add(a);
        for(int k=0; k<temp.size()-1; ++k) {
          adj[temp.get(k)][a] = true;
        }

      }
    }


    for(int i=1; i<=N; ++i) {
      for(int j=1; j<=N; ++j) {
        if(adj[i][j])
          indegree[j]++;
      }
    }

    for(int i=1; i<=N; ++i) {
      if(indegree[i] == 0) {
        q.add(i);
      }
    }

    StringBuilder sb = new StringBuilder();
    int cnt = 0;
    while(!q.isEmpty()) {
      cnt++;
      int cur = q.poll();

      sb.append(cur + "\n");

      // indegree 없애기
      for(int i=1; i<=N; ++i) {
        if(adj[cur][i]) {
          indegree[i]--;

          if(indegree[i] == 0) {
            q.add(i);
          }
        }
      }
    }

    if(cnt == N) {
      bw.write(sb.toString());
    } else {
      bw.write("0\n");
    }

    bw.flush();
  }
}