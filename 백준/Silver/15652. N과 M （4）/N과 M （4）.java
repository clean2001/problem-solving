import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


class Main {
  private static int N, M;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    dfs(1, new ArrayList<>());
  }

  private static void dfs(int cur, List<Integer> list) {
    if(list.size() == M) {
      for(int a : list) {
        System.out.print(a + " ");
      }
      System.out.println();
      return;
    }

    for(int i=cur; i<=N; ++i) {
      list.add(i);
      dfs(i, list);
      list.remove(list.size()-1);
    }
  }
}