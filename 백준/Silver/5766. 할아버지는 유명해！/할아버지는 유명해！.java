import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N, M;
    while(true) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      if(N == 0 && M == 0) break;

      Map<Integer, Integer> map = new HashMap<>();

      for(int i=0; i<N; ++i) {
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<M; ++j) {
          int person = Integer.parseInt(st.nextToken());

          int cnt = map.getOrDefault(person, 0);
          map.put(person, cnt+1);
        }
      }

      Queue<int[]> pq = new PriorityQueue<>((a, b) -> {
        if(a[1] == b[1]) return a[0] - b[0];
        return b[1] - a[1];
      });
      for (Map.Entry<Integer, Integer> e : map.entrySet()) {
        pq.add(new int[]{e.getKey(), e.getValue()});
      }

      pq.poll();
      int point = pq.peek()[1];
      while(!pq.isEmpty() && point == pq.peek()[1]) {
        bw.write(pq.poll()[0] + " ");
      }
      bw.write("\n");
    }

    bw.flush();
  }

}