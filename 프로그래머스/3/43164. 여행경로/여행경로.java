import java.util.*;

class Solution {
    static String[][] ticket;
    static boolean[] vis;
    static List<String> ans; 
    public String[] solution(String[][] tickets) {
        ticket = tickets;
        vis = new boolean[tickets.length];
        ans = new ArrayList<>();
        
        dfs("ICN", 0, "ICN");
        Collections.sort(ans);
        
        return ans.get(0).split(" ");    
    }
    
    private static void dfs(String cur, int depth, String list) {
        
        if(depth == ticket.length) {
            ans.add(list);
            return;
        }
        for(int i=0; i<ticket.length; ++i) {
            if(!vis[i] && ticket[i][0].equals(cur)) {
                vis[i] = true;
                dfs(ticket[i][1], depth+1, list + " " + ticket[i][1]);
                vis[i] = false;
            }
        }

    }
}