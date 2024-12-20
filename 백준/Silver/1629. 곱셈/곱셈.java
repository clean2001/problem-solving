
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    long A = Long.parseLong(st.nextToken());
    long B = Long.parseLong(st.nextToken());
    long C = Long.parseLong(st.nextToken());

    System.out.println(solve(A, B, C));
  }

  private static long solve(long A, long B, long C) {
    if(B == 0) return 1;
    if(B == 1) return A % C;

    if(B % 2 == 0) {
      long a = solve(A, B/2, C) % C;
      return ((a%C) * (a%C))  % C;
    } else {
      long a = solve(A, B/2, C) % C;
      return (((a%C) * (a%C)) % C * (A % C)) % C;
    }

    // 2 * 10^9
    // logn

  }
}
