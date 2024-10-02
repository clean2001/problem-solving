class Solution {
    public int solution(int n) {
        int left = 1; int right = 1;
        int cur = 1;
        int ans = 0;
        while(left <= n) {
            if(cur < n) { // 더 많이 더해야함
                cur += ++right;
            } else if(cur > n) { // 빼야함
                cur -= left++;
            } else {
                ans++;
                cur -= left++;
            }
        }
        
        return ans;
    }
}