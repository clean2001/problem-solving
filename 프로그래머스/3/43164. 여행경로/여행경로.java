import java.util.*;

class Solution {
    public static Deque<String> ans;
    public static List<String> ans1;
    public String[] solution(String[][] tickets) {
        ans = new LinkedList<>();
        ans1 = new ArrayList<>();
        // 뒤를 기준으로 오름차순 정렬
        Arrays.sort(tickets, (a, b) -> {
            return a[1].compareTo(b[1]);
        });
        
        for(int i=0; i<tickets.length; ++i) {
            if(tickets[i][0].equals("ICN")) {
                dfs(i, new boolean[tickets.length], tickets, 0);
            }
        }
        
        String[] answer = new String[ans1.size()];
        for(int i=0; i<ans1.size(); ++i) {
            answer[i] = ans1.get(i);
        }
        
        return answer;
    }
    
    public static void dfs(int cur, boolean[] vis, String[][] tickets, int cnt) {
        vis[cur] = true;
        ans.addLast(tickets[cur][0]);
        if(cnt == tickets.length-1) {
            ans.add(tickets[cur][1]);
            
            if(ans1.isEmpty()) {
                for(String a : ans) {
                    ans1.add(a);
                }
                return;
            }

        }
        
        for(int i=0; i<tickets.length; ++i) {
            if(vis[i]) continue;
            if(tickets[i][0].equals(tickets[cur][1])) { // 일치
                dfs(i, vis, tickets, cnt+1);
            }
        }
        
        vis[cur] = false;
        ans.pollLast();
    }
}