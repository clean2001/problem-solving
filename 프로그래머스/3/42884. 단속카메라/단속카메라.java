import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 나가는 순으로 오름차순
        Arrays.sort(routes, (a ,b) -> a[1] - b[1]);
        
        int minE = routes[0][1];
        int ans = 1;
        
        for(int i=1; i<routes.length; ++i) {
            int s = routes[i][0];
            int e = routes[i][1];
            
            if(s > minE) {
                ans++;
                
                // System.out.println(s + " " + e);
                minE = e;
                continue;
            }
        }
        
        return ans;
    }
}