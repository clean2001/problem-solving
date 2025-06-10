import java.io.*;
import java.security.MessageDigest;
import java.util.*;

class Main {
  private static int N, M, ans = 0;
  private static int[] arr, cnt;
  private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[N];
    cnt = new int[10001];
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<N; ++i) {
      arr[i] = Integer.parseInt(st.nextToken());
      cnt[arr[i]]++;
    }

    // 정렬
    Arrays.sort(arr);

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

    for(int i=idx; i<10001; ++i) {
      if(cnt[i] == 0) continue;

      list.add(i);
      cnt[i]--;
      dfs(i, list);
      cnt[i]++;
      list.remove(list.size()-1);
    }
  }
}