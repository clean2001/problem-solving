import java.util.*;
class Solution {
    static List<List<Integer>> adj;
    public int solution(int n, int[][] edge) {
        adj = new ArrayList<>();
        
        for(int i=0; i<=n; ++i) adj.add(new ArrayList<>());
        for(int[] e : edge) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        return bfs(1, n);
    }
    
    private static int bfs(int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        int maxDist = -1;
        int ret = 0;
        int[] dist = new int[end+1];
        for(int i=0; i<end+1; ++i) dist[i] = -1;
    
        q.add(start);
        dist[start] = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            if(dist[cur] == maxDist) {
                ret++;
            } else if(dist[cur] > maxDist) {
                maxDist = dist[cur];
                ret = 1;
            }
            
            List<Integer> nexts = adj.get(cur);
            for(int next : nexts) {
                if(dist[next] >= 0) continue;
                
                q.add(next);
                dist[next] = dist[cur] + 1;
            }
        }
        
        return ret;
    }
}