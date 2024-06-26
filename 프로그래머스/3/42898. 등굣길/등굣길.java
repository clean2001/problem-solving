import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];
        
        for(int[] p : puddles) {
            int y = p[1] - 1;
            int x = p[0] - 1;
            
            dp[y][x] = -1;
        }
    
        // dp 배열 채우기
        for(int i=0; i<n; ++i) {
            for(int j=0; j<m; ++j) {
                if(i==0 && j==0) {
                    dp[i][j] = 1;
                    continue;
                }
                if(dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                
                int m1 = i >= 1 ? Math.max(dp[i-1][j], 0) % 1000000007 : 0;
                int m2 = j >= 1 ? Math.max(dp[i][j-1], 0) % 1000000007 : 0;
                
                dp[i][j] = (m1 + m2) % 1000000007;
            }
        }
        
        // System.out.println(Arrays.deepToString(dp));
        return dp[n-1][m-1];
    }
}