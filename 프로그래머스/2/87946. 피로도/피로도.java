import java.util.*;
class Solution {
    private static int[][] dun;
    private static int ans = 0;
    public int solution(int k, int[][] dungeons) {
        dun = dungeons;
        
        dfs(k, 0, new boolean[dungeons.length]);
        
        return ans;
    }
    
    // permutation
    private static void dfs(int remain, int cnt, boolean[] vis) {
        ans = Math.max(cnt, ans);
        
        for(int i=0; i<dun.length; ++i) {
            if(vis[i]) continue;
            if(remain < dun[i][0] || remain < dun[i][1]) continue;
            
            vis[i] = true;
            dfs(remain - dun[i][1], cnt+1, vis);
            vis[i] = false;
        }
    }
}