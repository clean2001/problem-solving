import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {
  static int N, K;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    int[] prev = new int[100001];
    int[] dist = new int[100001];

    Queue<Integer> q = new LinkedList<>();
    q.add(N);
    dist[N] = 1;
    int cnt = 0;
    while(!q.isEmpty()) {
      int cur = q.poll();

      if(cur == K) {
        break;
      }

      if(cur - 1 >= 0 && dist[cur-1] == 0) {
        dist[cur-1] = dist[cur] + 1;
        prev[cur-1] = cur;
        q.add(cur-1);
      }

      if(cur + 1 <= 100000 && dist[cur+1] == 0) {
        dist[cur+1] = dist[cur] + 1;
        prev[cur+1] = cur;
        q.add(cur+1);
      }

      if(cur*2 <= 100000 && dist[cur*2] == 0) {
        dist[cur*2] = dist[cur] + 1;
        prev[cur*2] = cur;
        q.add(cur*2);
      }
    }

    // 역 추적
    Deque<Integer> dq = new LinkedList<>();
    dq.add(K);
    int cur = K;
    while(cur != N) {
      dq.addLast(prev[cur]);
      cur = prev[cur];
    }

    System.out.println(dq.size()-1);
    while(!dq.isEmpty()) {
      System.out.print(dq.pollLast() + " ");
    }
  }

}