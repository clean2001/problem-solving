class Solution {
    public int solution(int n) {
        int start = 1, end = 1;
        int ans = 0;
        int sum = end - start + 1;
        while(start <= end && end <= n) {
            if(sum == n) {
                ans++;
                sum -= start;
                start++;
            } else if(sum < n) {
                end++;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
        }
        return ans;
    }
    
    private static int makeSum(int n) {
        return n * (n+1) / 2;
    }
}