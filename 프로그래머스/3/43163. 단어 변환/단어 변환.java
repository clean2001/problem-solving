class Solution {
    static String end;
    static int ans = Integer.MAX_VALUE;
    static boolean[] vis;
    public int solution(String begin, String target, String[] words) {
        end = target;
        vis = new boolean[words.length];
        
        for(int i=0; i<words.length; ++i) {
            if(words[i].equals(begin)) {
                vis[i] = true;
                break;
            }
        }
        
        dfs(begin, words, 0);
        
        if(ans == Integer.MAX_VALUE) ans = 0;
        return ans;
    }
    
    static void dfs(String cur, String[] words, int depth) {
        if(cur.equals(end)) {
            ans = Math.min(depth, ans);
            return;
        }
        
        if(depth == words.length - 1) {
            return;
        }
        
        for(int i=0; i<words.length; ++i) {
            if(vis[i]) continue;
            
            if(isOne(words[i], cur)) {
                vis[i] = true;
                dfs(words[i], words, depth+1);
                vis[i] = false;
            }
        }
    }
    
    private static boolean isOne(String a, String b) {
        int cnt = 0;
        for(int i=0; i<a.length(); ++i) {
            if(a.charAt(i) != b.charAt(i)) {
                cnt++;
            }
        }
        
        if(cnt == 1) return true;
        return false;
    }
}