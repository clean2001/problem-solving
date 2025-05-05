import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    for(int i=0; i<N; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; ++j)
        pq.add(Integer.parseInt(st.nextToken()));
    }

    for(int i=0; i<N; ++i) {
      int cur = pq.poll();
      if(i == N-1) System.out.println(cur);
    }

  }
}