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

    Map<String, String> map = new HashMap<>();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    for(int i=0; i<N; ++i) {
      st = new StringTokenizer(br.readLine());

      String k = st.nextToken();
      String v = st.nextToken();

      map.put(k, v);
    }

    for(int i=0; i<M; ++i) {
      String k = br.readLine();
      bw.write(map.get(k) + "\n");
    }
    bw.flush();
  }
}