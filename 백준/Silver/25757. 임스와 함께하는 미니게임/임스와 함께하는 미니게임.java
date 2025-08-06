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

    int N = Integer.parseInt(st.nextToken());
    String game = st.nextToken();

    Set<String> set = new HashSet<>();
    for(int i=0; i<N; ++i) {
      String name = br.readLine();
      set.add(name);
    }

    int cnt = set.size();
    if(game.equals("Y")) {
      System.out.println(cnt);
    } else if(game.equals("F")) {
      System.out.println(cnt/2);
    } else {
      System.out.println(cnt/3);
    }
  }
}