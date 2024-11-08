class Solution {
    private static int ans = 0;
    public int solution(int k, int[][] dungeons) {
        dfs(k, dungeons, 0, new boolean[dungeons.length]);
        
        return ans;
    }
    
    private static void dfs(int remain, int dungeons[][], int cnt, boolean[] vis) {
        ans = Math.max(ans, cnt);
        
        for(int i=0; i<dungeons.length; ++i) {
            if(remain - dungeons[i][0] >= 0 && remain - dungeons[i][1] >= 0) {
                if(vis[i]) continue;
                vis[i] = true;
                dfs(remain - dungeons[i][1], dungeons, cnt + 1, vis);
                vis[i] = false;
            }
        }
    }
}