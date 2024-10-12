import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
  public static int[][] tree;
  public static int inCnt = 0;
  public static List<Integer> ans = new ArrayList<>();
  public static boolean[] vis;
  public static boolean[] inVis;
  public static List<Integer> inorders = new ArrayList<>();
  static boolean done = false;
  public static int cnt = 0, N = 0;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    vis = new boolean[N+1];
    inVis = new boolean[N+1];
    tree = new int[N+1][2];

    for(int i=1; i<=N; ++i) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      tree[a][0] = b;
      tree[a][1] = c;
    }
    inorder(1);
    dfs(1);
//    System.out.println(inorders.get(inorders.size() -1));
//    System.out.println(ans);
    System.out.println(ans.size() - 1);
  }

  public static void inorder(int cur) {
    int left = tree[cur][0];
    int right = tree[cur][1];

    if(left != -1) {
      inorder(left);
    }

    inorders.add(cur);

    if(right != -1) {
      inorder(right);
    }
  }

  public static void dfs(int cur) {
    if(done) return;
    if(!vis[cur]) {
      vis[cur] = true;
      cnt++;
    }

    ans.add(cur);
    if(cnt >= N && cur == inorders.get(inorders.size()-1)) {
      done = true; return;
    }

    int left = tree[cur][0];
    int right = tree[cur][1];

    if(left != -1 && !vis[left]) {
      dfs(left);
      if(done) return;
      ans.add(cur); // 부모 다시 방문
      if(cnt >= N && cur == inorders.get(inorders.size()-1)) {
//        System.out.println("done!!!!!");
        done = true; return;
      }

    }

    if(right != -1 && !vis[right]) {
      dfs(right);
      if(done) return;
      ans.add(cur); // 부모 다시 방문
      if(cnt >= N && cur == inorders.get(inorders.size()-1)) {
//        System.out.println("done!!!!!");
        done = true; return;
      }
    }
  }

}
