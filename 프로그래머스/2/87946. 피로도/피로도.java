import java.util.*;

class Solution {
    public static int ans = 0;
    public int solution(int k, int[][] dungeons) {
        perm(new ArrayList<int[]>(), k,dungeons, new boolean[dungeons.length]);
        return ans;
    }
    
    public void perm(ArrayList<int[]> list, int k, int[][] dungeons, boolean[] vis) {
        if(list.size() == dungeons.length) {
            // 돌면서 체크
            int cnt = 0;
            for(int[] a : list) {
                if(k >= a[0]) {
                    k -= a[1];
                    cnt++;
                }
            }
            
            ans = Math.max(ans, cnt);
            return;
        }
        
        for(int i=0; i<vis.length; ++i) {
            if(vis[i]) continue;
            vis[i] = true;
            list.add(dungeons[i]);
            perm(list, k, dungeons, vis);
            list.remove(list.size() - 1);
            vis[i] = false;
        }
    }
}