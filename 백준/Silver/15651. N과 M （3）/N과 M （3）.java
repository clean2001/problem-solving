import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {
  private static int[] arr, dp;
  private static BufferedWriter bw;
  private static int N, M;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    solve(new LinkedList<>(), 0);
    bw.flush();
  }

  private static void solve(Deque<Integer> list, int cnt) throws Exception {
    if(list.size() == M) {
      for(int a : list) {
       bw.write((a + " "));
      }
      bw.write("\n");
      return;
    }

    if(cnt == M) return;

    for(int i=1; i<=N; ++i) {
      list.addLast(i);
      solve(list, cnt+1);
      list.pollLast();
    }
  }

}