class Solution {
    static long[] dp;
    public long solution(int n) {
        dp = new long[n+2];
        
        dp[1] = 1L; dp[2] = 2L;
        for(int i=3; i<=n; ++i) {
            dp[i] = (dp[i-1] % 1234567 + dp[i-2] % 1234567) % 1234567;
        }
        
        return dp[n];
    }
}