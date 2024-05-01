import java.io.*;
import java.util.*;
// 1943. 동전 분배 
class Main {
  static int N;
  static List<Coin> list;
  static class Coin implements Comparable<Coin> {
    int m;
    int cnt;

    Coin(int m, int cnt) {
      this.m = m;
      this.cnt = cnt;
    }

    public int compareTo(Coin n) {
      return this.m - n.m;
    }
  }
  static boolean[] dp;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for(int t = 0; t < 3; ++t) {
      int sum = 0;
      N = Integer.parseInt(br.readLine());
      list = new ArrayList<>();
      for(int i=0; i<N; ++i) {
        dp = new boolean[100001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        sum += m * cnt;
        list.add(new Coin(m, cnt));

        for(int j=0; j<=cnt; ++j) {
          dp[j * m] = true;
        }
      }

      if(sum % 2 != 0) {
        System.out.println(0);
        continue;
      }

      if(dp[sum / 2]) {
        System.out.println(1);
        continue;
      }

      makeDp(sum);

      System.out.println(dp[sum / 2] ? 1 : 0);
    }

  }

  private static void makeDp(int sum) {
    dp[0] = true;
    for(int i=0; i<N; ++i) {
      int m = list.get(i).m;
      int cnt = list.get(i).cnt;

      for(int cur = sum/2; cur >= m; cur--) {
        if(dp[cur - m]) {
          for(int j=1; j<=cnt; ++j) {
            if(cur - m + m * j > sum / 2) break;
            dp[cur - m + m * j] = true;
          }
        }
      }
    }
  }
}