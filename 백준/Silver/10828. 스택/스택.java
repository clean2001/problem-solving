import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    Deque<Integer> dq = new LinkedList<>();
    for(int i=0; i<N; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      String cmd = st.nextToken();

      if(cmd.equals("push")) {
        int n = Integer.parseInt(st.nextToken());

        dq.addLast(n);
      } else if(cmd.equals("pop")) {
        if(dq.isEmpty()) {
          bw.write("-1\n");
        } else {
          bw.write(dq.pollLast() + "\n");
        }
      } else if(cmd.equals("size")) {
        bw.write(dq.size() + "\n");
      } else if(cmd.equals("empty")) {
        int ret = dq.isEmpty() ? 1 : 0;
        bw.write(ret + "\n");
      } else if(cmd.equals("top")) {
        if(dq.isEmpty()) {
          bw.write("-1\n");
        } else {
          bw.write(dq.peekLast() + "\n");
        }
      }
    }

    bw.flush();
  }
}