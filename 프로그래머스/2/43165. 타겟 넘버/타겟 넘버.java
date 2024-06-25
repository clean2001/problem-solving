class Solution {
    private static int ans = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        
        return ans;
    }
    
    private static void dfs(int depth, int curValue, int[] numbers, int target) {
        if(depth == numbers.length) {
            if(curValue == target) {
                ans++;
            }
            
            return;
        }
        
        dfs(depth+1, curValue + numbers[depth], numbers, target);
        dfs(depth+1, curValue - numbers[depth], numbers, target);
    }
}