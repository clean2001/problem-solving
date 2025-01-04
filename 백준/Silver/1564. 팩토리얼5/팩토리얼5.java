import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

public class Main {
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N, M;
  static int[][] map;
  static int ans = -1;

  static int[] dy = {1, -1, 0, 0};
  static int[] dx = {0, 0, 1, -1};
  static long MOD = 1000000;

  public static void main(String[] args) throws Exception {
    int N = Integer.parseInt(br.readLine());

    long fac = 1;
    int cnt1 = 0, cnt2 = 0;
    for(int i=1; i<=N; ++i) {
      int n = i;

      while(n % 5 == 0) {
        cnt1++;
        n /= 5;
      }

      while(n % 2 == 0) {
        cnt2++;
        n /= 2;
      }

      fac = (fac * n) % MOD;
    }

    int extra = cnt2 - cnt1;
    for(int i=0; i<extra; ++i) {
      fac = (fac * 2) % MOD;
    }

    String ans = String.valueOf(fac);
    while(ans.length() < 5) {
      ans = "0" + ans;
    }

    System.out.println(ans.substring(ans.length()-5));

  }

}