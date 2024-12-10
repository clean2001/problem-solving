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
    int cnt2 = 0;
    int cnt5 = 0;
    for(int i=2; i<=N; ++i) {
      int k = i;
      while(k % 2 == 0) {
        k /= 2;

        cnt2++;
      }

      k = i;
      while(k % 5 == 0) {
        k /= 5;
        cnt5++;
      }
    }

    System.out.println(Math.min(cnt2, cnt5));
  }
}