import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2098 {
    static int N;
    static int[][] W;
    static int[][] dp; //
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        W = new int[N+1][N+1];
        int col = (1 << N);

        dp = new int[N+1][col]; // 행 현재 위치, 열 방문여부, 값 나머지 다 돌았을때 최소 비용
        for(int i=1; i<=N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<=N; ++i) {
            for(int j=0; j<col; ++j) dp[i][j] = -1;
        }


        int ans = dfs(1, 1); // 1에서 시작, 1번만 방문

        System.out.println(ans);
    }
    static int dfs(int cur, int visit) {
        if(visit == (1<<N)-1) {
            if(W[cur][1] == 0) return 2000000000;
            return W[cur][1];
        }

        int cost = dp[cur][visit];
        if(cost != -1) return cost;

        dp[cur][visit] = 2000000000;
        for(int i=1; i<=N; ++i) {
            int is_visit = 1 << (i-1);

            if((is_visit & visit) > 0) continue; // 이미 감
            if(W[cur][i] == 0) continue; // 못감

            int nv = visit | is_visit;

            int tmp = dfs(i, nv);
//            System.out.println(i + " " + visit + " " + dp[cur][visit] + " " + tmp+W[cur][i]);
            dp[cur][visit] = Math.min(dp[cur][visit], tmp + W[cur][i]);


        }

        return dp[cur][visit];
    }
}
