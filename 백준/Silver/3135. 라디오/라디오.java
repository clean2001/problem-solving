import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int A, B, N;
    StringTokenizer st = new StringTokenizer(br.readLine());
    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(br.readLine());

    int ans = Math.abs(A - B);
    for(int i=0; i<N; ++i) {
      int K = Integer.parseInt(br.readLine());
      ans = Math.min(ans, Math.abs(B - K) + 1);
    }

    bw.write(ans + "\n");
    bw.flush();
  }

}