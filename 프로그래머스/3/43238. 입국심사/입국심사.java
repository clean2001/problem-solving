class Solution {
    public long solution(int n, int[] times) {
        long left = 0L, right = 1000000000L*100000L + 1L;
        long ans = right;
        while(left <= right) {
            long mid = (left + right) / 2;
            
            if(can(mid, n, times)) {
                right = mid-1;
                ans = Math.min(mid, ans);
            } else {
                left = mid+1;
            }
        }
        
        return ans;
    }
    
    private static boolean can(long mid, int n, int[] times) {
        long total = 0;
        for(int t : times) {
            total += (mid / (long)t);
        }
        
        if((long)n <= total) return true;
        return false;
    }
}