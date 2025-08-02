import java.io.*;
import java.util.*;

class Main {
  private static List<List<Integer>> adj;
  static int[] dy = {1, -1, 0, 0, 0, 0};
  static int[] dx = {0, 0, 1, -1, 0, 0};
  static int[] dz = {0, 0, 0, 0, 1, -1};
  static int N, M, K;
  static int[] vis;
  static int[] ans;
  static int turn = 1;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int a1 = Integer.parseInt(st.nextToken());
    int a2 = Integer.parseInt(st.nextToken());

    int c = Integer.parseInt(br.readLine());
    int n = Integer.parseInt(br.readLine());


    if(a1 > c) {
      System.out.println("0");
    } else {
      int left = a1 * n + a2;
      int right = c * n;

      int ans = left <= right ? 1 : 0;
      System.out.println(ans);
    }
  }
}