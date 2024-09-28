class Solution {
    static int ans = 0;
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return ans;
    }
    
    private void dfs(int index, int cur, int[] numbers, int target) {
        if(index == numbers.length) {
            if(target == cur) ans++;
            return;
        }
        
        dfs(index+1, cur+numbers[index], numbers, target);
        dfs(index+1, cur-numbers[index], numbers, target);
        
    }
}