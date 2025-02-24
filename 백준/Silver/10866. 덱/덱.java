import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {


  private static Map<String, Integer> map;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    Deque<Integer> dq = new LinkedList<>();
    while(N-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());

      String cmd = st.nextToken();

      switch (cmd) {
        case "push_back": {
          int num = Integer.parseInt(st.nextToken());
          dq.addLast(num);
          break;
        }
        case "push_front": {
          int num = Integer.parseInt(st.nextToken());
          dq.addFirst(num);
          break;
        }
        case "front":
          if (dq.isEmpty()) {
            bw.write("-1\n");
          } else {
            bw.write(dq.peekFirst() + "\n");
          }
          break;
        case "back":
          if (dq.isEmpty()) {
            bw.write("-1\n");
          } else {
            bw.write(dq.peekLast() + "\n");
          }
          break;
        case "size":
          bw.write(dq.size() + "\n");
          break;
        case "empty":
          if (dq.isEmpty()) {
            bw.write("1\n");
          } else {
            bw.write("0\n");
          }
          break;
        case "pop_front": {
          if (dq.isEmpty()) {
            bw.write("-1\n");
          } else {
            bw.write(dq.pollFirst() + "\n");
          }
          break;
        }
        case "pop_back": {
          if (dq.isEmpty()) {
            bw.write("-1\n");
          } else {
            bw.write(dq.pollLast() + "\n");
          }
        }

      }
    }

    bw.flush();
  }

}