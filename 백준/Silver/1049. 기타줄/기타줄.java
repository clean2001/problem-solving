import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N, M;
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    int[] six = new int[M];
    int[] one = new int[M];

    for(int i=0; i<M; ++i) {
      st = new StringTokenizer(br.readLine());
      six[i] = Integer.parseInt(st.nextToken());
      one[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(six);
    Arrays.sort(one);

    int ans = 0;
    if(six[0] > 6 * one[0]) {
      ans = N * one[0];
    } else {
      ans = Math.min((N / 6) * six[0] + (N % 6) * one[0], (N / 6 + 1) * six[0]);
    }
    System.out.println(ans);
  }
}