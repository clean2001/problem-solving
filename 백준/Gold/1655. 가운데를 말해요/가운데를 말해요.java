
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class Main {
  static int N;
  static boolean[][] vis;
  static int ans = 0;
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


  public static void main(String[] args) throws Exception {
    Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    Queue<Integer> minHeap = new PriorityQueue<>();

    int N = Integer.parseInt(br.readLine());
    for(int i=0; i<N; ++i) {
      int M = Integer.parseInt(br.readLine());

      if(maxHeap.isEmpty()) {
        maxHeap.add(M);
      } else if(minHeap.isEmpty()) {
        if(maxHeap.peek() > M) {
          minHeap.add(maxHeap.poll());
          maxHeap.add(M);
        } else {
          minHeap.add(M);
        }
      } else if(maxHeap.size() == minHeap.size()) {
        maxHeap.add(M);
      } else if(maxHeap.size() > minHeap.size()) {
        minHeap.add(M);
      }

      // 조정하기
      if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
        int temp = maxHeap.poll();
        int temp2 = minHeap.poll();

        maxHeap.add(temp2);
        minHeap.add(temp);
      }

//      bw.write(maxHeap + " " + minHeap);

      bw.write(maxHeap.peek() + "\n");
    }

    bw.flush();

  }


}