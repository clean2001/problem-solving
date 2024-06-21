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

    while(N-- > 0) {
      Deque<Character> dq = new LinkedList<>();
      String s = br.readLine();

      for(int i=0; i<s.length(); ++i) {
        char c = s.charAt(i);

        if (c == '(') {
          dq.addFirst(c);
        } else if(dq.isEmpty()) {
          dq.add('0');
          break;
        } else {
          dq.pollFirst();
        }
      }

      if(!dq.isEmpty()) {
        bw.write("NO\n");
      } else {
        bw.write("YES\n");
      }
    }

    bw.flush();
  }
}