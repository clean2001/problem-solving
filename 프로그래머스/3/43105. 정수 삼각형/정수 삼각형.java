import java.util.*;

class Solution {
    static int[][] dp;
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int m = triangle[n-1].length;
        dp = new int[n][m];
        
        
        dp[0][0] = triangle[0][0];
        // System.out.println(Arrays.deepToString(dp));
        for(int i=1; i<n; ++i) {
            for(int j=0; j<triangle[i].length; ++j) {
                if(j == 0) {
                    dp[i][j]  = triangle[i][j] + dp[i-1][j];
                } else if(j == triangle[i].length-1) {
                    dp[i][j]  = triangle[i][j] + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
                
            }
        }
        int answer = Integer.MIN_VALUE;
        for(int i=0; i<n; ++i) {
            answer = Math.max(answer, dp[n-1][i]);
        }
        return answer;
    }
}