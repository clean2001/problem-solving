import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for(int i=0; i<N; ++i) {
      int num = Integer.parseInt(br.readLine());
      if(num == 0 && pq.isEmpty()) {
        bw.write("0\n");
      } else if(num == 0) {
        bw.write(pq.poll() + "\n");
      } else {
        pq.add(num);
      }
    }

    bw.flush();
  }

}