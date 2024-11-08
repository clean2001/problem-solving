import java.util.*;

class Solution {
    List<List<Integer>> adj;
    public int solution(int n, int[][] edge) {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n+1];
        adj = new ArrayList<>();
        for(int i=0; i<=n; ++i) {
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<edge.length; ++i) {
            adj.get(edge[i][0]).add(edge[i][1]);
            adj.get(edge[i][1]).add(edge[i][0]);
        }
        
        q.add(1);
        dist[1] = 1;
        int maxDist = 1;
        int ans = 1;
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            List<Integer> nexts = adj.get(cur);
            for(int next : nexts) {
                if(dist[next] != 0) continue;
                dist[next] = dist[cur] + 1;
                q.add(next);
                
                if(maxDist == dist[next]) ans++;
                else {
                    maxDist = dist[next];
                    ans = 1;
                }
            }
        }
        
        return ans;
    }
}