class Solution {
    public long solution(int n, int[] times) {
        long left = 0;
        long right = (long)1e18 + 1L;
        long ans = right;
        while(left <= right) {
            long mid = (left + right) / 2; // mid분 안에 끝날 수 있는가
            
            boolean can = validate(n, times, mid);
            if(can) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return ans;
    }
    
    public static boolean validate(int n, int[] times, long mid) {
        long cnt = 0;
        for(int t : times) {
            cnt += mid / t;
        }
        
        if(cnt >= (long)n) return true;
        return false;
    }
}