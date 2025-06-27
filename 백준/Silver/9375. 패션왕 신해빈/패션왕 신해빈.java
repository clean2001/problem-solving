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

    int T = Integer.parseInt(br.readLine());
    while(T-- > 0) {
      int ans = 1;
      Map<String, Integer> map = new HashMap<>();

      int N = Integer.parseInt(br.readLine());
      for(int i=0; i<N; ++i) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        int cnt = map.getOrDefault(b, 0);
        map.put(b, cnt+1);
      }

      for(Map.Entry<String, Integer> e : map.entrySet()) {
        ans *= (1 + e.getValue());
      }

      bw.write(ans-1 + "\n");
    }

    bw.flush();
  }
}