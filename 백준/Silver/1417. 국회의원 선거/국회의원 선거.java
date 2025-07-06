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
    int[] dasom = new int[]{0};
    Queue<int[]> pq = new PriorityQueue<>((a ,b) -> {if(a[0] == b[0]) return b[1]-a[1]; return b[0] - a[0];});
    for(int i=0; i<N; ++i) {
      int a = Integer.parseInt(br.readLine());
      int[] arr = new int[] {a, i};
      if(i==0) {
        dasom = arr;
        continue;
      }
      pq.add(arr);
    }

    int ans = 0;
    while(!pq.isEmpty()) {
      int[] top = pq.poll();
      if(top[0] < dasom[0]) break;

      ans++;
      top[0]--;
      dasom[0]++;
      pq.add(top);
    }

    bw.write(ans + "\n");
    bw.flush();
  }
}