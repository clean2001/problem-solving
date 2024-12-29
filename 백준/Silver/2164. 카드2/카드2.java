import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class Main {
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;

  public static void main(String[] args) throws Exception {
    N = Integer.parseInt(br.readLine());
    Queue<Integer> q = new LinkedList<>();

    for(int i=1; i<=N; ++i) {
      q.add(i);
    }

    while(q.size() > 1) {
      q.poll();
      q.add(q.poll());
    }

    System.out.println(q.poll());
    
  }

}