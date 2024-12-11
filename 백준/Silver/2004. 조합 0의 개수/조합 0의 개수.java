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
    long a = Integer.parseInt(st.nextToken());
    long b = Integer.parseInt(st.nextToken());

    int num5 = solve(a, 5) - solve(b, 5) - solve(a - b , 5);
    int num2 = solve(a, 2) - solve(b, 2) - solve(a - b , 2);
    System.out.println(Math.min(num2, num5));
  }

  private static int solve(long n, long k) {
    int ret = 0;
    while(n > 0) {
      ret += n/k;
      n /= k;
    }

    return ret;
  }
}