import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
  static int N, M, ans = 0;
  static List<List<Integer>> adj;
  static int[] parents;

  static int findRoot(int cur) {
    if(parents[cur] == -1 || parents[cur] == cur) return parents[cur];

    return parents[cur] = findRoot(parents[cur]);
  }

  static void unionNodes(int a, int b) {
    int rootA = findRoot(a);
    int rootB = findRoot(b);

    if(rootA == rootB) return;

    if(rootA == -1) {
      parents[rootB] = rootA;
    } else {
      parents[rootA] = rootB;
    }

  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 사람 수
    M = Integer.parseInt(st.nextToken()); // 파티 수

    parents = new int[N+1];
    for(int i=0; i<N+1; ++i) {
      parents[i] = i;
    }

    st = new StringTokenizer(br.readLine());
    int K = Integer.parseInt(st.nextToken()); // 진실을 아는 사람 수
    for(int i=0; i<K; ++i) {
      int cur = Integer.parseInt(st.nextToken());
      parents[cur] = -1;
    }

    int[][] inputs = new int[M][N+1];
    for(int i=0; i<M; ++i) {
      st = new StringTokenizer(br.readLine());

      int cnt = Integer.parseInt(st.nextToken());

      for(int j=0; j<cnt; ++j) {
        inputs[i][j] = Integer.parseInt(st.nextToken());

        if(j > 0)
          unionNodes(inputs[i][j-1], inputs[i][j]);
      }

    }

    // 다시 돌기
    for(int i=0; i<M; ++i) {
      int j=0;
      boolean pass = false;
      while(inputs[i][j] > 0) {
        if(findRoot(inputs[i][j]) == -1) {
          pass = true;
          break;
        }
        j++;
      }

      if(!pass) ans++;
    }

    System.out.println(ans);

  }
}