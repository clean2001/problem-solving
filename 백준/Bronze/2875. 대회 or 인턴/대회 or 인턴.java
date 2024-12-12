import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int ans = 0;
    for(ans=1; ans <= 100; ++ans) {
      // 되는지 체크
      int r1 = N - ans * 2;
      int r2 = M - ans;
      if(r1 < 0 || r2 < 0 || r1 + r2 < K) {
        ans--;
        break;
      }
    }

    System.out.println(ans);
  }
}