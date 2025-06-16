import java.io.*;
import java.security.MessageDigest;
import java.util.*;

class Main {
  private static int C; // 채워야하는 수
  private static int N; // 도시 개수
  private static int[][] arr; // 비용, 사람
  private static int[] dp; // 사람, 비용
  private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    List<Integer> list = new ArrayList<>();
    for(int i=0; i<N; ++i) {
      list.add(Integer.parseInt(st.nextToken()));
    }

    Collections.sort(list);

    int p1 = 0, p2 = 1, p3 = 2;
    long sum = 9000000001L;
    for(int i=0; i<N-2; ++i) {
      int l = i+1, r = N-1;
      while(l < r) {
        long cur = (long)list.get(l) + list.get(i) + list.get(r);

        if(Math.abs(cur) < Math.abs(sum)) {
          sum = cur;
          p1 = i; p2 = l; p3 = r;
        } else if(cur < 0) l++;
        else r--;
      }
    }

    System.out.println(list.get(p1) + " " + list.get(p2) + " " + list.get(p3));
  }
}