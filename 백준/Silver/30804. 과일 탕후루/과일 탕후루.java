import java.io.*;
import java.security.MessageDigest;
import java.util.*;
import java.util.jar.Attributes;

class Main {
  private static List<List<Integer>> adj;
  static int[] dy = {1, -1, 0, 0};
  static int[] dx = {0, 0, 1, -1};
  static int R, C, T;
  static int[][] map;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[] arr = new int[N];
    for (int i = 0; i < N; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    if (N <= 2) {
      System.out.println(N);

    } else {
      int l = 0, r = 1;
      int cnt;
      int ans = 1;
      if (arr[l] == arr[r]) cnt = 1;
      else cnt = 2;

      int[] chk = new int[10];
      chk[arr[l]]++;
      chk[arr[r]]++;

      while (r < N - 1) {
//      System.out.println(cnt);
        r++;
        chk[arr[r]]++;
        if (chk[arr[r]] == 1) {
          cnt++;
          while (cnt > 2 && l < r) {
            chk[arr[l]]--;
            if (chk[arr[l]] == 0) cnt--;
            l++;
          }
        }

        ans = Math.max(ans, r - l + 1);
      }

      System.out.println(ans);
    }
  }
}