import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.PrimitiveIterator.OfInt;

class Main {
  static int N;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    Deque<Integer> stack = new LinkedList<>();
    while(N-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int cmd = Integer.parseInt(st.nextToken());
      switch(cmd) {
        case 1:
          stack.addFirst(Integer.parseInt(st.nextToken()));
          break;
        case 2:
          if(stack.isEmpty()) {
            bw.write("-1\n");
          } else {
            bw.write(stack.pollFirst() + "\n");
          }
          break;
        case 3:
          bw.write(stack.size() + "\n");
          break;
        case 4:
          bw.write((stack.isEmpty() ?  1 : 0) + "\n");
          break;
        case 5:
          if(stack.isEmpty()) {
            bw.write("-1\n");
          } else {
            bw.write(stack.peekFirst() + "\n");
          }
          break;
      }
    }

    bw.flush();
  }
}