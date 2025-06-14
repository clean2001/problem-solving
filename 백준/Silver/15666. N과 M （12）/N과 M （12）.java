import java.io.*;
import java.security.MessageDigest;
import java.util.*;

class Main {
  private static int N, M, ans = 0;
  private static int[] cnt;
  private static List<Integer> arr;
  private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    cnt = new int[10001];
    arr = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; ++i) {
      int a = Integer.parseInt(st.nextToken());
      if(cnt[a] == 0) arr.add(a);
      cnt[a] = 1;
    }

    Collections.sort(arr);

    dfs(0, new ArrayList<>());

    bw.flush();
  }

  private static void dfs(int idx, List<Integer> list) throws Exception {
      if(list.size() == M) {
        for(int e : list) {
          bw.write(e + " ");
        }
        bw.write("\n");
        return;
      }

    for(int i=idx; i<arr.size(); ++i) {
      list.add(arr.get(i));
      dfs(i, list);
      list.remove(list.size()-1);
    }
  }
}