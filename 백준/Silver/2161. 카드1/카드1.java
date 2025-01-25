import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    Deque<Integer> dq = new LinkedList<>();

    for(int i=0; i<N; ++i) {
      dq.addLast(i+1);
    }

    while(dq.size() > 1) {
      bw.write(dq.pollFirst() + " ");
      dq.addLast(dq.pollFirst());
    }

    bw.write(dq.poll() + " ");
    bw.flush();
  }

}