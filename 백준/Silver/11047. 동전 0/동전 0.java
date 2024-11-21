import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    Integer[] coins = new Integer[N];
    for(int i=0; i<N; ++i) {
      coins[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(coins, Comparator.reverseOrder());

    int ans = 0;
    for(int coin : coins) {
      ans += (K / coin);
      K %= coin;
    }

    System.out.println(ans);
  }
}