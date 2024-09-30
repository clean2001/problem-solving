import java.util.*;

class Solution {
    public static List<List<Integer>> adj = new ArrayList<>();
    public static boolean[] vis;
    public int solution(int n, int[][] computers) {
        vis = new boolean[n];
        for(int i=0; i<n; ++i) {
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<n; ++i) {
            for(int j=0; j<n; ++j) {
                if(computers[i][j] == 1)
                    adj.get(i).add(j);
            }
        }
        
        int cnt = 0;
        for(int i=0; i<n; ++i) {
            if(vis[i]) continue;
            bfs(i);
            cnt++;
            // System.out.println("!!");
        }
        
        
        return cnt;
    }
    
    public static void bfs(int s) {
        vis[s] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while(!q.isEmpty()) {
            
            int cur = q.poll();
            // System.out.println(cur);
            List<Integer> nexts = adj.get(cur);
            for(int n : nexts) {
                if(vis[n]) continue;
                vis[n] = true;
                q.add(n);
            }
        }
    }
}