import java.util.*;

class Solution {
    static long[] dp;
    static int[] ans;
    public int[] solution(int n, long k) {
        dp = new long[n+1];
        ans = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            list.add(i);
        }
        
        dfs(n, k-1, list, 0);
        return ans;
    }
    
    static void dfs(int n, long k, ArrayList<Integer> list, int idx) {
        // if(k == 1) return;
        if(n == 0) return;
        long fact = factorial(n-1);
        
        long a = k / fact;
         k %= fact;
        
        ans[idx] = list.remove((int)a);
        
        
        dfs(n-1, k, list, idx+1);
        
    }
    
    static long factorial(int n) {
        if(n == 0) return 1;
        if(dp[n] > 0) return dp[n];
        dp[n] = factorial(n-1) * n;
        return dp[n];
    }
}