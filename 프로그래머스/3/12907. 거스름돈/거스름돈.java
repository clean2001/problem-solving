import java.util.*;
class Solution {
    static int[] dp;
    public int solution(int n, int[] money) {
        dp = new int[n+1];
        for(int m : money) {
            dp[m]++;
            for(int cur = m; cur <= n; cur++) {
                dp[cur] = (dp[cur] + dp[cur-m]) % 1000000007;
            }
        }
        
        // System.out.println(Arrays.toString(dp));
        
        return dp[n];
    }

}