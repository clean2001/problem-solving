import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    Deque<int[]> dq = new ArrayDeque<>();
    for(int i=0; i<N; ++i) {
      dq.addLast(new int[] {Integer.parseInt(st.nextToken()), i+1});
    }


    int[] cur = dq.pollFirst();
    int cnt = cur[0];
    int turn = cur[1];
    bw.write(turn + " ");
    while(!dq.isEmpty()) {
      if(cnt > 0) {
        for(int i=0; i<cnt; ++i) {
          dq.addLast(dq.pollFirst());
        }

        cur = dq.pollLast();
        cnt = cur[0];
        turn = cur[1];

        bw.write(turn + " ");
      } else {
        cnt = -cnt;
        for(int i=0; i<cnt; ++i) {
          dq.addFirst(dq.pollLast());
        }

        cur = dq.pollFirst();
        cnt = cur[0];
        turn = cur[1];
        bw.write(turn + " ");
      }
    }

    bw.flush();
  }
}