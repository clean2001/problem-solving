import java.util.*;

class Solution {
    public static List<List<Integer>> adj;
    public int solution(int n, int[][] edge) {
        adj = new ArrayList<>();
        for(int i=0; i<=n; ++i) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] e : edge) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        return bfs(n);
        
    }
    
    public static int bfs(int n) {
        int ans = 0;
        int maxDist = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0}); // 노드, dist
        
        boolean[] vis = new boolean[n+1];
        vis[1] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            List<Integer> nexts = adj.get(cur[0]);
            for(int next : nexts) {
                if(vis[next]) continue;
                
                int dist = cur[1] + 1;
                vis[next] = true;
                q.add(new int[]{next, dist});
                
                if(dist == maxDist) {
                    ans++;
                } else if(dist > maxDist) {
                    maxDist = dist;
                    ans = 1;
                }
            }
        }
        
        return ans;
    }
}