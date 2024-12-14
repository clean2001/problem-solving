import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    Queue<Integer> pq = new PriorityQueue<>();
    for(int i=0; i<N; ++i) {
      int k = Integer.parseInt(br.readLine());

      if(k == 0) {
        if(pq.isEmpty()) {
          bw.write("0\n");
        } else {
          bw.write(pq.poll() + "\n");
        }
      } else {
        pq.add(k);
      }
    }

    bw.flush();
  }
}