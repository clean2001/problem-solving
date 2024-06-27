class Solution {
    public int solution(int n) {
        int start = 1, end = 1;
        int ans = 0;
        while(start <= end && end <= n) {
            int sum = makeSum(end) - makeSum(start-1);
            if(sum == n) {
                ans++;
                start++;
            } else if(sum < n) {
                end++;
            } else {
                start++;
            }
        }
        return ans;
    }
    
    private static int makeSum(int n) {
        return n * (n+1) / 2;
    }
}