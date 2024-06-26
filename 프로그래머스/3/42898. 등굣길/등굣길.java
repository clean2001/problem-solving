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
                if(dp[i][j] == -1) continue;
                if(i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                } else if(i == 0) {
                    dp[i][j] = Math.max(0, dp[i][j-1]);
                    continue;
                } else if(j == 0) {
                    dp[i][j] = Math.max(0, dp[i-1][j]);
                    continue;
                }
                
                int m1 = Math.max(dp[i-1][j], 0) % 1000000007;
                int m2 = Math.max(dp[i][j-1], 0) % 1000000007;
                
                dp[i][j] = (m1 + m2) % 1000000007;
            }
        }
        
        return dp[n-1][m-1];
    }
}