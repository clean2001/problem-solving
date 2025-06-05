import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.*;

class Main {
  private static int N, S, ans = 0;
  private static int[] arr, sum;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    arr = new int[N+1];
    sum = new int[N+1];
    for(int i=1; i<=N; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
      sum[i] = arr[i] + sum[i-1];
    }
    dfs(1, 0, new ArrayList<>());
    System.out.println(ans);

  }

  private static void dfs(int idx, int subSum, List<Integer> a) {
      if(subSum == S && idx > 1) {
        ans++;

//        for(int e : a ) {
//          System.out.print(e + " ");
//        }
//        System.out.println();
      }

    for(int i=idx; i<=N; ++i) {
      a.add(arr[i]);
      dfs(i+1, subSum + arr[i], a);
      a.remove(a.size()-1);
    }
  }
}