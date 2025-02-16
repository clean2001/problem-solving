import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

  private static boolean[] vis;
  private static int[] arr;
  private static Map<String, Integer> map;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int K = Integer.parseInt(br.readLine());

    vis = new boolean[N];
    arr = new int[N];
    map = new HashMap<>();

    for(int i=0; i<N; ++i) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    dfs(N, K, "", 0);

    int ans = 0;

    System.out.println(map.size());
  }

  public static void dfs(int N, int k, String s, int cnt) {
    if(cnt == k) {
      int num = map.getOrDefault(s, 0);
      map.put(s, num+1);

      return;
    }

    for(int i=0; i<N; ++i) {
      if(vis[i]) continue;

      vis[i] = true;
      dfs(N, k, s + String.valueOf(arr[i]), cnt+1);

      vis[i] = false;
    }
  }
}