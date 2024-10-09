import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {
  public static int[][] dp;
  public static int N, M, K;
  public static List<List<int[]>> load;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 도시의 개수(=도착해야하는 곳)
    M = Integer.parseInt(st.nextToken()); // 최대로 거칠 수 있는 도시 수
    K = Integer.parseInt(st.nextToken()); // 항공로의 개수

    load = new ArrayList<>();
    for(int i=0; i<=N; ++i) {
      load.add(new ArrayList<>());
    }

    for(int i=0; i<K; ++i) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      if(a >= b) continue;

      load.get(a).add(new int[]{b, c});
    }

    dp = new int[M+1][N+1];
    for(int i=0; i<=M; ++i) {
      for(int j=0; j<=N; ++j) {
        if(i == 0) {
          dp[i][j] = 0;
        } else {
          dp[i][j] = -1;
        }
      }
    }

    dp[1][1] = 0; // 1에서 출발하기 때문에, 이때 기내식 점수는 총합은 0점이다.
    for(int i=1; i<M; ++i) {
      for(int j=1; j<=N; ++j) {
        if(dp[i][j] != -1) {
          List<int[]> nexts = load.get(j);
          for (int[] next : nexts) {
            int k = next[0];
            int point = next[1];

            dp[i+1][k] = Math.max(dp[i+1][k], dp[i][j] + point);
          }
        }
      }
    }


    int ans = -1;
    for(int i=1; i<=M; ++i) {
      ans = Math.max(ans, dp[i][N]);
    }

    System.out.println(ans);

  }

}