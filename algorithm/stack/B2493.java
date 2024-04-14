import java.io.*;
import java.util.*;
// 2493. 탑
class Main {
  static class Top {
    int idx;
    int height;

    Top(int idx, int height) {
      this.idx = idx;
      this.height = height;
    }

  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N+1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i=1; i<=N; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Deque<Top> dq = new LinkedList<>();
    dq.add(new Top(1, arr[1]));
    System.out.print("0 ");
    for(int i=2; i<=N; ++i) {
      while(!dq.isEmpty() && dq.peekLast().height < arr[i]) {
        dq.pollLast();
      }
      if (dq.isEmpty()) {
        System.out.print("0 ");
      } else {
        System.out.print(dq.peekLast().idx + " ");
      }
      dq.add(new Top(i, arr[i]));
    }
  }
}