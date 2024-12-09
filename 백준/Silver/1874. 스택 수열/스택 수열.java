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
    int[] arr = new int[N];
    int p = 0;
    int n = 1;
    for(int i=0; i<N; ++i) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    Deque<Integer> dq = new LinkedList<>();
    Deque<Character> ret = new LinkedList<>();
    while(p < N) {
      if(arr[p] >= n) {
        dq.addLast(n);
        ret.addLast('+');
        n++;
      } else {
        if(dq.peekLast() == arr[p]) {
          p++;
          ret.addLast('-');
          dq.pollLast();
        } else {
          System.out.println("NO");
          System.exit(0);
        }
      }
    }

    while(!ret.isEmpty()) {
      bw.write(ret.pollFirst() + "\n");
    }
    bw.flush();
  }
}