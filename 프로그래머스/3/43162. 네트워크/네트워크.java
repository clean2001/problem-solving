import java.util.*;

class Solution {
    static List<List<Integer>> adj;
    static boolean[] vis;
    static int ans = 0;
    public int solution(int n, int[][] computers) {
        adj = new ArrayList<>();
        for(int i=0; i<n; ++i) {
            adj.add(new ArrayList<>());
        }
        vis = new boolean[n];
        
        // 인접 리스트에 추가
        for(int i=0; i<n; ++i) {
            for(int j=i+1; j<n; ++j) {
                if(computers[i][j] == 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        for(int i=0; i<n; ++i) {
            if(vis[i]) continue;  
            ans++;
            bfs(i);
        }
        
        return ans;
    }
    
    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            // 인접 리스트 돌기
            List<Integer> nexts = adj.get(cur);
            for(int next : nexts) {
                if(vis[next]) continue;
                
                vis[next] = true;
                q.add(next);
            }
        }
    }
}