class Solution {
    static int ans = 0;
    static boolean isDone;
    public int solution(String word) {
        dfs("", word);
        return ans;
    }
    
    private static void dfs(String cur, String word) {
        if(cur.length() > 5) return;
        if(isDone) return;
        
        if(cur.equals(word)) {
            isDone = true;
            return;
        }
        
        ans++;
        dfs(cur + "A", word);
        dfs(cur + "E", word);
        dfs(cur + "I", word);
        dfs(cur + "O", word);
        dfs(cur + "U", word);

    }
}