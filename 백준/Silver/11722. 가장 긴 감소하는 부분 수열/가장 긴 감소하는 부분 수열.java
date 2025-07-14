import java.io.*;
import java.security.MessageDigest;
import java.util.*;
import java.util.jar.Attributes;

class Main {
  private static List<List<Integer>> adj;
  static int[] dy = {1, -1, 0, 0, 0, 0};
  static int[] dx = {0, 0, 1, -1, 0, 0};
  static int[] dz = {0, 0, 0, 0, 1, -1};
  static int N, C, T;
  static int[][][] map;
  static int[][][] vis;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for(int i=0; i<N; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[N];// 여기부터 시작시 가장긴 부분 수열
    dp[0] = 1;
    int ans = 1;
    for(int i=1; i<N; ++i) {
      int len = 1;
      for(int j=0; j<i; ++j) {
        if(arr[j] > arr[i]) {
          len = Math.max(len, dp[j]+1);
        }
      }

      dp[i] = len;
      ans = Math.max(ans, dp[i]);
    }

    bw.write(ans+"\n");
    bw.flush();
  }

}