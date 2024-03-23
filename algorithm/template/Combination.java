// N과 M(2) combination
import java.io.*;
import java.util.*;
public class Combination {
    static int N, M;
    static int ans = 0;
    static boolean[] vis;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        vis = new boolean[N+1];

        dfs(0, 1);

    }

    static void dfs(int depth, int idx) {
        if(depth == M) {
            for (int a : list) {
                System.out.print(a + " ");
            }

            System.out.println();
            return;
        }

        for(int i=idx; i<=N; ++i) {
            if(vis[i]) continue;

            list.add(i);
            vis[i] = true;
            dfs(depth+1, i+1);
            vis[i] = false;
            list.remove(list.size()-1);
        }
    }

}
