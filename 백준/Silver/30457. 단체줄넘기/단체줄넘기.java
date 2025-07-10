import java.io.*;
import java.security.MessageDigest;
import java.util.*;
import java.util.jar.Attributes;

class Main {
  private static List<List<Integer>> adj;
  static int[] dy = {1, -1, 0, 0};
  static int[] dx = {0, 0, 1, -1};
  static int N, C, T;
  static char[][] map;
  static boolean[][] vis;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    boolean[] vis = new boolean[N];
    for(int i=0; i<N; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);

    int prev = arr[0];
    vis[0] = true;
    int cnt = 1;
    for(int i=1; i<N; ++i) {
      if (prev == arr[i]) continue;

      vis[i] = true;
      prev = arr[i];
      cnt++;
    }

    prev = -1;
    for(int i=0; i<N; ++i) {
      if(vis[i]) continue;
      if(prev >= arr[i]) continue;
      vis[i] = true;
      prev = arr[i];
      cnt++;
    }

    bw.write(cnt+"\n");
    bw.flush();
  }

}