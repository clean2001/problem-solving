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
      StringTokenizer st = new StringTokenizer(br.readLine());

      int cmd = Integer.parseInt(st.nextToken());

      switch(cmd) {
        case 1:
          int num1 = Integer.parseInt(st.nextToken());
          dq.addFirst(num1);
          break;

        case 2:
          int num2 = Integer.parseInt(st.nextToken());
          dq.addLast(num2);
          break;

        case 3:
          if(dq.isEmpty()) {
            bw.write("-1\n");
          } else {
            bw.write(dq.pollFirst() + "\n");
          }
          break;

        case 4:
          if(dq.isEmpty()) {
            bw.write("-1\n");
          } else {
            bw.write(dq.pollLast() + "\n");
          }
          break;

        case 5:
          bw.write(dq.size() + "\n");
          break;

        case 6:
          int ret = dq.isEmpty() ? 1 : 0;
          bw.write(ret + "\n");
          break;

        case 7:
          if(dq.isEmpty()) {
            bw.write("-1\n");
          } else {
            bw.write(dq.peekFirst() + "\n");
          }
          break;

        case 8:
          if(dq.isEmpty()) {
            bw.write("-1\n");
          } else {
            bw.write(dq.peekLast() + "\n");
          }
          break;
      }
    }

    bw.flush();

  }
}