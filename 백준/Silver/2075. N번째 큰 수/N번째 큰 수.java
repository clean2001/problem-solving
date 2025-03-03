import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for(int i=0; i<N; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j=0; j<N; ++j) {
        pq.add(Integer.parseInt(st.nextToken()));
      }
    }

    for(int i=0; i<N-1; ++i) pq.poll();

    System.out.println(pq.poll());


  }
}