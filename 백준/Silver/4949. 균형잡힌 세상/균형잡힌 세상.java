import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.PrimitiveIterator.OfInt;

class Main {
  static int N;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String line;

    while(!(line = br.readLine()).equals(".")) {
      Deque<Character> dq = new LinkedList<>();
      for(int i=0; i<line.length(); ++i) {
        char c = line.charAt(i);
        if(c == '[' || c == '(') {
          dq.addFirst(c);
        } else if(c == ']') {
          if(dq.isEmpty()) {
            dq.add(' ');
            break;
          }
          if(dq.peekFirst() == '[') {
            dq.poll();
          } else {
            break;
          }
        } else if(c == ')') {
          if(dq.isEmpty()) {
            dq.add(' ');
            break;
          }

          if(dq.peekFirst() == '(') {
            dq.poll();
          } else {
            break;
          }
        }
      }
      if(dq.isEmpty()) {
        bw.write("yes\n");
      } else {
        bw.write("no\n");
      }
    }
    bw.flush();
  }
}